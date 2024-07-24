//package com.example.edu.controller;//package com.example.edu.controller;
//
//import com.example.edu.model.FoodInfoVO;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//public class FoodSearchController {
//
//    @RequestMapping(value = "/food")
//    public String bookSearchPage() throws Exception {
//        return "food";
//    }
//
//    @RequestMapping(value = "/foodsearch")
////    public String bookSearchList(String keyword, Model model) {
////        String url = "https://apis.data.go.kr/1471000/FoodNtrIrdntInfoService1/getFoodNtrItdntList1?ServiceKey=DsUAduFiNXosF4vwy50AMcCRk9sYGUOEuVAXTab4UL%2BxhoqapEvU33LLFozTQYcRSVmIkGqX4Xke5XheHQIAwg%3D%3D&numOfRows=20&type=json&desc_kor=" + keyword;
////
////        RestTemplate restTemplate = new RestTemplate();
////        String result = restTemplate.getForObject(url, String.class);
////        System.out.println(result);
//
//        public String bookSearchList(String keyword, Integer page, Model model) {
//            if (page == null || page < 1) {
//                page = 1; // 기본 페이지 번호를 1로 설정
//            }
//
//            String url = "https://apis.data.go.kr/1471000/FoodNtrIrdntInfoService1/getFoodNtrItdntList1?ServiceKey=DsUAduFiNXosF4vwy50AMcCRk9sYGUOEuVAXTab4UL%2BxhoqapEvU33LLFozTQYcRSVmIkGqX4Xke5XheHQIAwg%3D%3D&numOfRows=20&pageNo=" + page + "&type=json&desc_kor=" + keyword;
//            RestTemplate restTemplate = new RestTemplate();
//            String result = restTemplate.getForObject(url, String.class);
//            System.out.println(result);
//
//        try {
//            // 응답이 XML 형식인지 확인
//            if (result.trim().startsWith("<")) {
//                model.addAttribute("errorMessage", "API 서버 에러입니다. 잠시 후 다시 이용해주세요.");
//
//                System.out.println("API 서버 에러입니다. 잠시 후 다시 이용해주세요.");
//                return "foodSearchResult";
//            }
//
//
//            ObjectMapper mapper = new ObjectMapper();
//            JsonNode root = mapper.readTree(result);
//            JsonNode items = root.path("body").path("items");
//            JsonNode totalCount = root.path("body").path("totalCount");
//
//
//            List<FoodInfoVO> foods = new ArrayList<>();
//            for (JsonNode item : items) {
//                FoodInfoVO food = new FoodInfoVO();
//                food.setDescKor(item.path("DESC_KOR").asText());
//                food.setServingWt(item.path("SERVING_WT").asText());
//                food.setNutrCont1(item.path("NUTR_CONT1").asText());
//                food.setNutrCont2(item.path("NUTR_CONT2").asText());
//                food.setNutrCont3(item.path("NUTR_CONT3").asText());
//                food.setNutrCont4(item.path("NUTR_CONT4").asText());
//                food.setNutrCont5(item.path("NUTR_CONT5").asText());
//                food.setNutrCont6(item.path("NUTR_CONT6").asText());
//                food.setNutrCont7(item.path("NUTR_CONT7").asText());
//                food.setNutrCont8(item.path("NUTR_CONT8").asText());
//                food.setNutrCont9(item.path("NUTR_CONT9").asText());
//                food.setBgnYear(item.path("BGN_YEAR").asText());
//                food.setAnimalPlant(item.path("ANIMAL_PLANT").asText());
//
//
//
//                foods.add(food);
//            }
//
//            model.addAttribute("foods", foods);
//            model.addAttribute("keyword", keyword);
//            model.addAttribute("totalCount", totalCount);
//            System.out.println("토탈: " + totalCount);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return "foodSearchResult";
//    }
//}

////package com.example.edu.controller;
////
////import com.example.edu.model.FoodInfoVO;
////import com.fasterxml.jackson.databind.JsonNode;
////import com.fasterxml.jackson.databind.ObjectMapper;
////import org.springframework.stereotype.Controller;
////import org.springframework.ui.Model;
////import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.client.RestTemplate;
////
////import java.util.ArrayList;
////import java.util.List;
////
////@Controller
////public class FoodSearchController {
////
////    @RequestMapping(value = "/food")
////    public String bookSearchPage() throws Exception {
////        return "food";
////    }
////
////    @RequestMapping(value = "/foodsearch")
////    public String bookSearchList(String keyword, Model model) {
////        String url = "https://apis.data.go.kr/1471000/FoodNtrIrdntInfoService1/getFoodNtrItdntList1?ServiceKey=DsUAduFiNXosF4vwy50AMcCRk9sYGUOEuVAXTab4UL%2BxhoqapEvU33LLFozTQYcRSVmIkGqX4Xke5XheHQIAwg%3D%3D&numOfRows=20&pageNo=1&type=json&desc_kor=" + keyword;
////
////        RestTemplate restTemplate = new RestTemplate();
////        String result = restTemplate.getForObject(url, String.class);
////        System.out.println(result);
////
////        try {
////            // 응답이 XML 형식인지 확인
////            if (result.trim().startsWith("<")) {
////                model.addAttribute("errorMessage", "API 서버 에러입니다. 잠시 후 다시 이용해주세요.");
////                System.out.println("API 서버 에러입니다. 잠시 후 다시 이용해주세요.");
////                return "foodSearchResult";
////            }
////
////            ObjectMapper mapper = new ObjectMapper();
////            JsonNode root = mapper.readTree(result);
////            JsonNode items = root.path("body").path("items");
////            JsonNode totalCountNode = root.path("body").path("totalCount");
////
////            int totalCount = totalCountNode.asInt();
////            int totalPages = (int) Math.ceil((double) totalCount / 20);
////
////            List<FoodInfoVO> foods = new ArrayList<>();
////            for (JsonNode item : items) {
////                FoodInfoVO food = new FoodInfoVO();
////                food.setDescKor(item.path("DESC_KOR").asText());
////                food.setServingWt(item.path("SERVING_WT").asText());
////                food.setNutrCont1(item.path("NUTR_CONT1").asText());
////                food.setNutrCont2(item.path("NUTR_CONT2").asText());
////                food.setNutrCont3(item.path("NUTR_CONT3").asText());
////                food.setNutrCont4(item.path("NUTR_CONT4").asText());
////                food.setNutrCont5(item.path("NUTR_CONT5").asText());
////                food.setNutrCont6(item.path("NUTR_CONT6").asText());
////                food.setNutrCont7(item.path("NUTR_CONT7").asText());
////                food.setNutrCont8(item.path("NUTR_CONT8").asText());
////                food.setNutrCont9(item.path("NUTR_CONT9").asText());
////                food.setBgnYear(item.path("BGN_YEAR").asText());
////                food.setAnimalPlant(item.path("ANIMAL_PLANT").asText());
////
////                foods.add(food);
////            }
////
////            model.addAttribute("foods", foods);
////            model.addAttribute("totalCount", totalCount);
////            model.addAttribute("totalPages", totalPages);
////            System.out.println("총 검색 결과: " + totalCount);
////            System.out.println("총 페이지 수: " + totalPages);
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////
////        return "foodSearchResult";
////    }
////}
//package com.example.edu.controller;
//
//import com.example.edu.model.FoodInfoVO;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//public class FoodSearchController {
//
//    private static final int ROWS_PER_PAGE = 20; // 한 페이지당 표시할 항목 수
//
//    @RequestMapping(value = "/food")
//    public String bookSearchPage() throws Exception {
//        return "food";
//    }
//
//    @RequestMapping(value = "/foodsearch")
//    public String bookSearchList(String keyword, Integer page, Model model) {
//        if (page == null || page < 1) {
//            page = 1; // 기본 페이지 번호를 1로 설정
//        }
//
//        String url = "https://apis.data.go.kr/1471000/FoodNtrIrdntInfoService1/getFoodNtrItdntList1?ServiceKey=DsUAduFiNXosF4vwy50AMcCRk9sYGUOEuVAXTab4UL%2BxhoqapEvU33LLFozTQYcRSVmIkGqX4Xke5XheHQIAwg%3D%3D&numOfRows=20&pageNo=" + page + "&type=json&desc_kor=" + keyword;
//
//        RestTemplate restTemplate = new RestTemplate();
//        String result = restTemplate.getForObject(url, String.class);
//        System.out.println(result);
//
//        try {
//            // 응답이 XML 형식인지 확인
//            if (result.trim().startsWith("<")) {
//                model.addAttribute("errorMessage", "API 서버 에러입니다. 잠시 후 다시 이용해주세요.");
//
//                System.out.println("API 서버 에러입니다. 잠시 후 다시 이용해주세요.");
//                return "foodSearchResult";
//            }
//
//
//            try {
//                ObjectMapper mapper = new ObjectMapper();
//                JsonNode root = mapper.readTree(result);
//                JsonNode items = root.path("body").path("items");
//                JsonNode totalCountNode = root.path("body").path("totalCount");
//
//                int totalCount = totalCountNode.asInt();
//                int totalPages = (int) Math.ceil((double) totalCount / ROWS_PER_PAGE);
//
//                List<FoodInfoVO> foods = new ArrayList<>();
//                for (JsonNode item : items) {
//                    FoodInfoVO food = new FoodInfoVO();
//                    food.setDescKor(item.path("DESC_KOR").asText());
//                    food.setServingWt(item.path("SERVING_WT").asText());
//                    food.setNutrCont1(item.path("NUTR_CONT1").asText());
//                    food.setNutrCont2(item.path("NUTR_CONT2").asText());
//                    food.setNutrCont3(item.path("NUTR_CONT3").asText());
//                    food.setNutrCont4(item.path("NUTR_CONT4").asText());
//                    food.setNutrCont5(item.path("NUTR_CONT5").asText());
//                    food.setNutrCont6(item.path("NUTR_CONT6").asText());
//                    food.setNutrCont7(item.path("NUTR_CONT7").asText());
//                    food.setNutrCont8(item.path("NUTR_CONT8").asText());
//                    food.setNutrCont9(item.path("NUTR_CONT9").asText());
//                    food.setBgnYear(item.path("BGN_YEAR").asText());
//                    food.setAnimalPlant(item.path("ANIMAL_PLANT").asText());
//
//                    foods.add(food);
//                }
//
//                model.addAttribute("foods", foods);
//                model.addAttribute("totalCount", totalCount);
//                model.addAttribute("totalPages", totalPages);
//                model.addAttribute("currentPage", page); // 현재 페이지 번호를 모델에 추가
//
//                System.out.println("총 검색 결과: " + totalCount);
//                System.out.println("총 페이지 수: " + totalPages);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            return "foodSearchResult";
//        }
//    }
//}

package com.example.edu.controller;

import com.example.edu.model.FoodInfoVO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import java.util.ArrayList;
import java.util.List;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


@Controller
public class FoodSearchController {

    private static final int ROWS_PER_PAGE = 20; // 한 페이지당 표시할 항목 수
    private static final String SERVICE_KEY = "DsUAduFiNXosF4vwy50AMcCRk9sYGUOEuVAXTab4UL%2BxhoqapEvU33LLFozTQYcRSVmIkGqX4Xke5XheHQIAwg%3D%3D";


    @RequestMapping(value = "/food")
    public String bookSearchPage() throws Exception {
        return "food";
    }

    @RequestMapping(value = "/foodsearch")
    public String foodSearchList(String keyword, Integer page, Model model) {
        if (page == null || page < 1) {
            page = 1; // 기본 페이지 번호를 1로 설정
        }
        StringBuilder urlBuilder = new StringBuilder("https://apis.data.go.kr/1471000/FoodNtrIrdntInfoService1/getFoodNtrItdntList1?ServiceKey=DsUAduFiNXosF4vwy50AMcCRk9sYGUOEuVAXTab4UL%2BxhoqapEvU33LLFozTQYcRSVmIkGqX4Xke5XheHQIAwg%3D%3D");
        try { //urlBuilder에 각 파라미터를 추가
            urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + SERVICE_KEY);
            urlBuilder.append("&" + URLEncoder.encode("desc_kor", "UTF-8") + "=" + URLEncoder.encode(keyword, "UTF-8"));
            urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("20", "UTF-8"));
            urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(page), "UTF-8"));
            urlBuilder.append("&" + URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));
        } catch (Exception e) {
            model.addAttribute("errorMessage", "URL 인코딩 에러가 발생했습니다."); //에러메시지를 모델에 추가하여 뷰를 반환함
            return "foodSearchResult";
        }

        String url = urlBuilder.toString(); //완성된 url을 문자열로 변환

        try {
            URL apiURL = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) apiURL.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");
            // API URL을 사용하여 객체를 생성하고 GET요청을 설정

            int responseCode = conn.getResponseCode();
            BufferedReader rd;
            if (responseCode >= 200 && responseCode <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                model.addAttribute("errorMessage", "API 서버 에러입니다. 잠시 후 다시 이용해주세요.");
                return "foodSearchResult";
            }
            // 응답코드 확인 후 , 성공적인 응답일 경우 데이터를 읽고, 오류가 발생하면 에러메시지를 모델에 추가하여 뷰를 반환함

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            rd.close();
            conn.disconnect();

            // 응답 데이터를 한 줄씩 읽어 StringBuilder에 추가

            String result = sb.toString();
            // 결과를 문자열로 변환

            ObjectMapper mapper = new ObjectMapper(); // objectMapper를 사용하여 JSON 응답을 파싱하고 필요한 JSON노드를 가져옴
            JsonNode root = mapper.readTree(result);
            JsonNode items = root.path("body").path("items");
            JsonNode totalCountNode = root.path("body").path("totalCount");

            int totalCount = totalCountNode.asInt();
            int totalPages = (int) Math.ceil((double) totalCount / ROWS_PER_PAGE);
            //총 아이템 수를 가져와서 페이지 수 계산

            List<FoodInfoVO> foods = new ArrayList<>(); // 결과를 저장할 객체 리스트 생성
            for (JsonNode item : items) { // JSON 데이터를 FoodInfoVo 객체에 매핑하고 리스트에 추가
                FoodInfoVO food = new FoodInfoVO();
                food.setDescKor(item.path("DESC_KOR").asText());
                food.setServingWt(item.path("SERVING_WT").asText());
                food.setNutrCont1(item.path("NUTR_CONT1").asText());
                food.setNutrCont2(item.path("NUTR_CONT2").asText());
                food.setNutrCont3(item.path("NUTR_CONT3").asText());
                food.setNutrCont4(item.path("NUTR_CONT4").asText());
                food.setNutrCont5(item.path("NUTR_CONT5").asText());
                food.setNutrCont6(item.path("NUTR_CONT6").asText());
                food.setNutrCont7(item.path("NUTR_CONT7").asText());
                food.setNutrCont8(item.path("NUTR_CONT8").asText());
                food.setNutrCont9(item.path("NUTR_CONT9").asText());
                food.setBgnYear(item.path("BGN_YEAR").asText());
                food.setAnimalPlant(item.path("ANIMAL_PLANT").asText());

                foods.add(food);
            }

            model.addAttribute("foods", foods); // 모델에 데이터(음식리스트, 총개수, 총페이지수,현재페이지)를 추가
            model.addAttribute("totalCount", totalCount);
            model.addAttribute("totalPages", totalPages);
            model.addAttribute("currentPage", page);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "데이터를 처리하는 중 에러가 발생했습니다.");
        }

        return "foodSearchResult";
    }


//    @RequestMapping(value = "/foodsearch")
//    public String bookSearchList(String keyword, Integer page, Model model) throws UnsupportedEncodingException {
//        if (page == null || page < 1) {
//            page = 1; // 기본 페이지 번호를 1로 설정
//        }
//
//        String encodedKeyword = URLEncoder.encode(keyword, "UTF-8");
//        String url = "https://apis.data.go.kr/1471000/FoodNtrIrdntInfoService1/getFoodNtrItdntList1?ServiceKey=DsUAduFiNXosF4vwy50AMcCRk9sYGUOEuVAXTab4UL%2BxhoqapEvU33LLFozTQYcRSVmIkGqX4Xke5XheHQIAwg%3D%3D&numOfRows=20&pageNo=" + page + "&type=json&desc_kor=" + encodedKeyword;
//        RestTemplate restTemplate = new RestTemplate();
//        String result = restTemplate.getForObject(url, String.class);
//        System.out.println(url);
//        System.out.println(result);
//
//        try {
//            // 응답이 XML 형식인지 확인
//            if (result.trim().startsWith("<")) {
//                model.addAttribute("errorMessage", "API 서버 에러입니다. 잠시 후 다시 이용해주세요.");
//
//                System.out.println("API 서버 에러입니다. 잠시 후 다시 이용해주세요.");
//                return "foodSearchResult";
//            }
//
//
//            try {
//                ObjectMapper mapper = new ObjectMapper();
//                JsonNode root = mapper.readTree(result);
//                JsonNode items = root.path("body").path("items");
//                JsonNode totalCountNode = root.path("body").path("totalCount");
//
//                int totalCount = totalCountNode.asInt();
//                int totalPages = (int) Math.ceil((double) totalCount / ROWS_PER_PAGE);
//
//                List<FoodInfoVO> foods = new ArrayList<>();
//                for (JsonNode item : items) {
//                    FoodInfoVO food = new FoodInfoVO();
//                    food.setDescKor(item.path("DESC_KOR").asText());
//                    food.setServingWt(item.path("SERVING_WT").asText());
//                    food.setNutrCont1(item.path("NUTR_CONT1").asText());
//                    food.setNutrCont2(item.path("NUTR_CONT2").asText());
//                    food.setNutrCont3(item.path("NUTR_CONT3").asText());
//                    food.setNutrCont4(item.path("NUTR_CONT4").asText());
//                    food.setNutrCont5(item.path("NUTR_CONT5").asText());
//                    food.setNutrCont6(item.path("NUTR_CONT6").asText());
//                    food.setNutrCont7(item.path("NUTR_CONT7").asText());
//                    food.setNutrCont8(item.path("NUTR_CONT8").asText());
//                    food.setNutrCont9(item.path("NUTR_CONT9").asText());
//                    food.setBgnYear(item.path("BGN_YEAR").asText());
//                    food.setAnimalPlant(item.path("ANIMAL_PLANT").asText());
//
//                    foods.add(food);
//                }
//
//                model.addAttribute("foods", foods);
//                model.addAttribute("totalCount", totalCount);
//                model.addAttribute("totalPages", totalPages);
//                model.addAttribute("currentPage", page); // 현재 페이지 번호를 모델에 추가
//
//                System.out.println("총 검색 결과: " + totalCount);
//                System.out.println("총 페이지 수: " + totalPages);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            return "foodSearchResult";
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return "foodSearchResult";
//    }
}