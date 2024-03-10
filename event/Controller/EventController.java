package org.example.event.Controller;

import org.example.event.Model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("event")
public class EventController {
    ArrayList<Event> events=new ArrayList<>();
    @GetMapping("/display")
    public ArrayList<Event> display(){
    return events;
    }

    @PostMapping("/add")
    public String addEvent(@RequestBody Event event){
        events.add(event);
        return "Event added successfully";
    }

    @PutMapping("/update/{index}")
    public String updateEvent(@PathVariable int index,@RequestBody Event event){
        events.set(index,event);
        return "Event updated ";
    }
    @DeleteMapping("/delete/{index}")
    public String deleteEvent(@PathVariable int index){
        events.remove(index);
        return "Event deleted";
    }

    @PutMapping("/change/{cap}/{id}")
    public String changeCapacity(@PathVariable int cap,@PathVariable int id){
        for(Event e:events){
            if (e.getId()==id){
                e.setCapacity(cap);
                return "Capacity changed"+e.getCapacity();
            }
        }
        return "the event id not exist ";
    }

    @GetMapping("/search/{id}")
    public String searchById(@PathVariable int id){
        for (Event e:events){
            if (e.getId()==id){
                return "The event :"+e;
            }
        }
return "The event not exist in the system";
    }
}
