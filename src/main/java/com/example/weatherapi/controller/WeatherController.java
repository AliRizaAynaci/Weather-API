package com.example.weatherapi.controller;

import com.example.weatherapi.model.WeatherResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/")
public class WeatherController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/")
    public String getWeather(@RequestParam String cityName, Model model) {
        String apiKey = "b0ba387517e52bc3bcfe46e37d66baab";
        String unit = "metric";
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + apiKey + "&units=" + unit;

        RestTemplate restTemplate = new RestTemplate();
        WeatherResponse weatherResponse = restTemplate.getForObject(url, WeatherResponse.class);

        if (weatherResponse == null) {
            return "404";
        }

        String weatherDescription = weatherResponse.getWeather().get(0).getDescription();
        String temp = weatherResponse.getMain().getTemp();
        String icon = weatherResponse.getWeather().get(0).getIcon();
        String imageURL = "http://openweathermap.org/img/wn/" + icon + "@2x.png";

        model.addAttribute("weatherDescription", weatherDescription);
        model.addAttribute("temp", temp);
        model.addAttribute("imageURL", imageURL);
        return "result";
    }
}
