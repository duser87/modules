package ru.innopolis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EarthquakeDataRemoteHostResponse {
    private List<EarthquakeDataRemoteHostResponse.Features> features;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Features{
        private EarthquakeDataRemoteHostResponse.Properties properties;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Properties{
        private String title;
        private Long time;
        private String place;
        private Double mag;
    }
}
