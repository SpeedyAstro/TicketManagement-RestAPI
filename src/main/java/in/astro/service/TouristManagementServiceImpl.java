package in.astro.service;

import in.astro.dao.ITouristRepo;
import in.astro.exception.TouristNotFound;
import in.astro.model.Tourist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TouristManagementServiceImpl implements  ITouristManagementService{

    @Autowired
    private ITouristRepo repo;
    @Override
    public String registerTourist(Tourist tourist) {
        Integer id = repo.save(tourist).getId();
        return "Tourist Registered with ID ::"+id;
    }

    @Override
    public List<Tourist> fetAllTourist() {
        List<Tourist> tourists = repo.findAll();
        tourists.sort((t1,t2) -> t1.getId().compareTo(t2.getId()));
        return tourists;
    }

    @Override
    public Tourist fetchTouristById(Integer id) {
//        Optional<Tourist> optional = repo.findById(id);
//        if (optional.isPresent()) return optional.get() ;
//        else throw new TouristNotFound(id+" <- Record not Found !!");
        return repo.findById(id).orElseThrow(()-> new TouristNotFound(id+" <- Record not Found !!"));
    }

    @Override
    public String updateTourist(Tourist tourist) {
        Optional<Tourist> optional = repo.findById(tourist.getId());
        if (optional.isPresent()){
            repo.save(tourist);
            return "Tourist with id "+tourist.getId()+" Saved Successfully!";
        }else throw new TouristNotFound("Record Don't exists with the id ::"+tourist.getId());
    }

    @Override
    public String updateTouristById(Integer id, Float HikePercent) {
        Optional<Tourist> optional = repo.findById(id);
        if (optional.isPresent()){
            Tourist tourist = optional.get();
            tourist.setBudget(tourist.getBudget()+(tourist.getBudget()*(HikePercent)/100));
            repo.save(tourist);
            return "Tourist Budget Update With the % "+HikePercent+", final Hike Amount is "+tourist.getBudget();
        }else {
            throw new TouristNotFound("Record Not Found with id "+id);
        }
    }

    @Override
    public String deleteTouristById(Integer id) {
        Optional<Tourist> optional = repo.findById(id);
        if (optional.isPresent()){
            repo.delete(optional.get());
            return "Tourist With the ID "+id+" Deleted Successfully!!";
        }else throw new TouristNotFound("Record not Found with id "+id);
    }
}
