package com.tindi.jolt;
import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.List;

public class TestJolt {
    private static final ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    public static void main(String[] args) throws Exception {
        System.out.println("=================================================");
        System.out.println("BFF JOLT MAPPING POC: INITIATED");
        System.out.println("=================================================\n");

        // TEST 1: Backend Domain -> Frontend React UI
        System.out.println(">>> TEST 1: BACKEND TO FRONTEND (UI MAPPING)");
        executeJoltTransformation(
                "/input-backend-asset.json",
                "/spec-backend-to-frontend.json"
        );

        System.out.println("\n-------------------------------------------------\n");

        // TEST 2: Frontend React UI -> Backend Domain
        System.out.println(">>> TEST 2: FRONTEND TO BACKEND (REVERSE MAPPING)");
        executeJoltTransformation(
                "/input-frontend-truck.json",
                "/spec-frontend-to-backend.json"
        );

        System.out.println("\n=================================================");
        System.out.println("POC VALIDATION COMPLETE");
        System.out.println("=================================================");
    }

    /**
     * Reusable method demonstrating how the WebFlux BFF will execute mappings dynamically
     * based entirely on externalized file paths.
     */
    private static void executeJoltTransformation(String inputFilePath, String specFilePath) throws Exception {

        // 1. Load the Data Dictionary Rules (Jolt Spec) from external file
        List<Object> chainrSpecJSON = JsonUtils.classpathToList(specFilePath);
        Chainr chainr = Chainr.fromSpec(chainrSpecJSON);

        // 2. Load the actual input payload from external file
        Object inputJSON = JsonUtils.classpathToObject(inputFilePath);

        // 3. Execute the mapping (This is the only processing the BFF actually does)
        Object transformedOutput = chainr.transform(inputJSON);

        // 4. Print results (Pretty printed for POC validation)
        System.out.println("INPUT FILE USED: " + inputFilePath);
        System.out.println("SPEC FILE USED : " + specFilePath);
        System.out.println("TRANSFORMED RESULT:");
        System.out.println(mapper.writeValueAsString(transformedOutput));
    }
}
