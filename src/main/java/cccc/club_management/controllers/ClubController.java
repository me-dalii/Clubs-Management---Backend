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

    @GetMapping("/leader/{username}")
    public Club getClubByLeaderUsername(@PathVariable(name = "username") String username) throws NotFoundException {
        return clubService.getClubByLeaderUsername(username);
    }

    @PutMapping("/{clubId}/coordinator/{coordinatorId}")
    public Club updateClubCoordinator(@PathVariable(name = "clubId") Long clubId, @PathVariable(name = "coordinatorId") Long coordinatorId) throws NotFoundException {
        return clubService.updateClubCoordinator(clubId, coordinatorId);
    }

    @PutMapping("/{clubId}/status")
    public Club updateClubStatus(@PathVariable(name = "clubId") Long clubId, @RequestBody boolean status) throws NotFoundException {
        return clubService.updateClubStatus(clubId, status);
    }

    @PostMapping("/details")
    public Club saveClubDetails(@RequestBody Club club) throws Exception {
        return this.clubService.saveClubDetails(club);
    }

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

        return this.clubService.saveClub(logo_file, FSBrequest_file, UCrequest_file, id, name, description, email, coordinatorId, leaderId);
    }

    @DeleteMapping("/{id}")
    public void deleteClub(@PathVariable(name = "id") Long id) throws NotFoundException {
        clubService.deleteClub(id);
    }

    @GetMapping("/approved")
    public List<Club> getApprovedClubs(){
        return clubService.getApprovedClubs();
    }

    @GetMapping("/count/approved")
    public Long getTotalApprovedClubs(){
        return clubService.getTotalApprovedClubs();
    }

    @GetMapping("/count/requested")
    public Long getTotalRequestedClubs(){
        return clubService.getTotalRequestedClubs();
    }


}