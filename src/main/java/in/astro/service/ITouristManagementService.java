package in.astro.service;

import in.astro.model.Tourist;

import java.util.List;

public interface ITouristManagementService {
    public String registerTourist(Tourist tourist);
    public List<Tourist> fetAllTourist();
    public Tourist fetchTouristById(Integer id);
    public String updateTourist(Tourist tourist);
    public String updateTouristById(Integer id, Float HikeAmt);

    public String deleteTouristById(Integer id);
}
