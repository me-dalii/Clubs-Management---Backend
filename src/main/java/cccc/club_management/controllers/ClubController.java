package cccc.club_management.controllers;

import cccc.club_management.exceptions.NotFoundException;
import cccc.club_management.models.Club;
import cccc.club_management.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/club")
public class ClubController {

    @Autowired
    private ClubService clubService;

    @GetMapping("/")
    public List<Club> getClubs(){
        return clubService.getClubs();
    }

    @GetMapping("/{id}")
    public Club getClubById(@PathVariable(name = "id") Long id) throws NotFoundException {
        return clubService.getClubById(id);
    }

/*    @PostMapping("/")
    public Club saveClub(@RequestBody Club club){
        return clubService.saveClub(club);
    }*/

    @PostMapping("/")
    public Club saveClub(@Nullable @RequestParam(name = "logo_file") MultipartFile logo_file,
                           @Nullable @RequestParam(name = "FSBrequest_file") MultipartFile FSBrequest_file,
                           @Nullable @RequestParam(name = "UCrequest_file") MultipartFile UCrequest_file,
                           @Nullable @RequestParam("id") Long id,
                           @Nullable @RequestParam("name") String name,
                           @Nullable @RequestParam("description") String description,
                           @Nullable @RequestParam("email") String email,
                           @Nullable @RequestParam("coordinatorId") Long coordinatorId,
                           @Nullable @RequestParam("leaderId") Long leaderId) throws Exception {

        System.out.println(logo_file);
        return this.clubService.saveClub(logo_file, FSBrequest_file, UCrequest_file, id, name, description, email, coordinatorId, leaderId);
    }

    @DeleteMapping("/{id}")
    public void deleteClub(@PathVariable(name = "id") Long id) throws NotFoundException {
        clubService.deleteClub(id);
    }
}