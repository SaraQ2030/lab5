package org.example.tracker2.Controller;

import lombok.AllArgsConstructor;
import org.apache.tomcat.util.digester.ArrayStack;
import org.example.tracker2.Model.Tracker;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/track")
public class TrackerController {
    ArrayList<Tracker> trackers=new ArrayList<>();
    @GetMapping("/display")
    public ArrayList<Tracker> display(){
        return trackers;
    }

    @PostMapping("/add")
    public String addTracker(@RequestBody Tracker tracker){
        trackers.add(tracker);
        return "data added successfully";
    }

    @DeleteMapping("/delete/{index}")
    public String deleteTrack(@PathVariable int index){
        trackers.remove(index);
        return "Data Deleted";
    }

    @PutMapping("/update/{index}")
    public String updateTrack(@PathVariable int index ,@RequestBody Tracker tracker){
        trackers.set(index,tracker) ;
        return "Updated successflly";
    }

    @GetMapping("search/title/{tit}")
    public String searchTitle(@PathVariable String tit){
        for (Tracker t:trackers){
            if (t.getTitle().equalsIgnoreCase(tit)){
                return "the result :"+"\n"+t;

            }
        }
        return "the title not found ";
    }

    @GetMapping("change/{index}")
    public String changeStatus(@PathVariable int index){
      if (trackers.get(index).getStatus().equalsIgnoreCase("done")){

          return "the Status Already done";
        }
      else    trackers.get(index).setStatus("done");
return "status changed successfully ";
    }

    @GetMapping("comp/{com}")
    public ArrayList<Tracker> displayByComName(@PathVariable String com){
        ArrayList<Tracker> company=new ArrayList<>();
        for (Tracker t:trackers){
            if (t.getCompanyName().equalsIgnoreCase(com)){
                 company.add(t);
                         }
        }
        return company;
    }





}
