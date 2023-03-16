package com.people.realestate.advice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Aspect
@Component
public class LoggingAspect {

    private RestHighLevelClient elasticsearchClient;

    public LoggingAspect(RestHighLevelClient elasticsearchClient) {
        this.elasticsearchClient = elasticsearchClient;
    }
    @Around("execution(* com.people.realestate.controller.*.*(..))")
    public Object logRequestAndResponse(ProceedingJoinPoint joinPoint) throws Throwable {
        // Get the request data
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        Map<String, String> headers = Collections.list(request.getHeaderNames())
                .stream()
                .collect(Collectors.toMap(h -> h, h -> request.getHeader(h)));

        // Call the method and get the response data
        Object result = joinPoint.proceed();
        int status = ((ResponseEntity<?>) result).getStatusCodeValue();
        HttpHeaders responseHeaders = ((ResponseEntity<?>) result).getHeaders();
        Map<String, String> responseHeadersMap = responseHeaders.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> String.join(",", e.getValue())));
        Object responseBody = ((ResponseEntity<?>) result).getBody();

        // Create an Elasticsearch document with the request and response data

        IndexRequest indexRequest = new IndexRequest("my_index_request_response")

                .source(Map.of(
                        "request", Map.of(
                                "method", method,
                                "uri", uri,
                                "headers", headers,
                                "timestamp", Instant.now(),
                                "body", getRequestBody(request)
                        ),
                        "response", Map.of(
                                "status", status,
                                "headers", responseHeadersMap,
                                "body", responseBody,
                                "timestamp", Instant.now()
                        )
                ));
        elasticsearchClient.index(indexRequest, RequestOptions.DEFAULT);

        return result;
    }

    private String getHeaders(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        Map<String, String> headers = new HashMap<>();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            headers.put(headerName, headerValue);
        }
        return headers.toString();
    }

    private String getHeaders(HttpServletResponse response) {
        Collection<String> headerNames = response.getHeaderNames();
        Map<String, String> headers = new HashMap<>();
        for (String headerName : headerNames) {
            String headerValue = response.getHeader(headerName);
            headers.put(headerName, headerValue);
        }
        return headers.toString();
    }

    private String getRequestBody(HttpServletRequest request) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
            StringBuilder requestBodyBuilder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                requestBodyBuilder.append(line);
            }
            return requestBodyBuilder.toString();
        }
    }
}

