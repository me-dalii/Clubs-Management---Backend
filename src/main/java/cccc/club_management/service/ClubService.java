package cccc.club_management.service;

import cccc.club_management.exceptions.NotFoundException;
import cccc.club_management.models.Club;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ClubService {
    List<Club> getClubs();
    Club getClubById(Long id) throws NotFoundException;
    Club getClubByLeaderUsername(String username) throws NotFoundException;
    Club updateClubStatus(Long id, boolean status) throws NotFoundException;
    Club updateClubCoordinator(Long clubId, Long coordinatorId) throws NotFoundException;
    Club saveClubDetails(Club club)  throws NotFoundException;
    Club saveClub(MultipartFile logo_file,
                  MultipartFile FSBrequest_file,
                  MultipartFile UCrequest_file,
                  Long id,
                  String name,
                  String description,
                  String email,
                  Long coordinatorId,
                  Long leaderId) throws Exception;
    void deleteClub(Long id) throws NotFoundException;
}