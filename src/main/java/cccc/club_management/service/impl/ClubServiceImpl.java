package cccc.club_management.service.impl;

import cccc.club_management.exceptions.NotFoundException;
import cccc.club_management.models.Club;
import cccc.club_management.models.CustomFile;
import cccc.club_management.models.Teacher;
import cccc.club_management.models.User;
import cccc.club_management.repositories.ClubRepository;
import cccc.club_management.repositories.CustomFileRepository;
import cccc.club_management.repositories.TeacherRepository;
import cccc.club_management.repositories.UserRepository;
import cccc.club_management.service.ClubService;
import cccc.club_management.service.TeacherService;
import cccc.club_management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClubServiceImpl implements ClubService {

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private CustomFileRepository customFileRepository;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Override
    public List<Club> getClubs() {
        return this.clubRepository.findAll();
    }

    @Override
    public Club getClubById(Long id) throws NotFoundException {
        if(this.clubRepository.findById(id).isPresent()) {
            return this.clubRepository.findById(id).get();
        }else{
            throw new NotFoundException();
        }
    }

    @Override
    public Club getClubByLeaderUsername(String username) throws NotFoundException {
        User leader = this.userRepository.findByAccount_Username(username);
        return this.clubRepository.findByLeader(leader);
    }

    @Override
    public Club saveClubDetails(Club updatedClub) throws NotFoundException{
        if(this.clubRepository.findById(updatedClub.getId()).isPresent()) {
            Club club = this.clubRepository.findById(updatedClub.getId()).get();
            club.setName(updatedClub.getName());
            club.setEmail(updatedClub.getEmail());
            club.setDescription(updatedClub.getDescription());
            return this.clubRepository.save(club);
        }else{
            throw new NotFoundException();
        }
    }

    @Override
    public Club updateClubCoordinator(Long clubId, Long coordinatorId) throws NotFoundException{
        if(this.clubRepository.findById(clubId).isPresent() && this.teacherRepository.findById(coordinatorId).isPresent()) {
            Club club = this.clubRepository.findById(clubId).get();
            Teacher coordinator = this.teacherRepository.findById(coordinatorId).get();
            club.setCoordinator(coordinator);
            return this.clubRepository.save(club);
        }else{
            throw new NotFoundException();
        }
    }

    @Override
    public Club updateClubStatus(Long clubId, boolean status) throws NotFoundException{
        if(this.clubRepository.findById(clubId).isPresent()) {
            Club club = this.clubRepository.findById(clubId).get();
            club.setStatus(status);
            return this.clubRepository.save(club);
        }else{
            throw new NotFoundException();
        }
    }

    @Override
    public Club saveClub(MultipartFile logo_file, MultipartFile FSBrequest_file, MultipartFile UCrequest_file, Long id, String name, String description, String email, Long coordinatorId, Long leaderId) throws Exception {

        Club club = new Club(id, name, description, email);
        System.out.println(club);
        User leader;
        if(leaderId != null){
            leader = this.userService.getUserById(leaderId);
            club.setLeader(leader);
        }


        Teacher coordinator;
        if(coordinatorId != null){
            coordinator = this.teacherService.getTeacherById(coordinatorId);
            club.setCoordinator(coordinator);
        }


        if (logo_file != null) {
            String logo_fileName = StringUtils.cleanPath(logo_file.getOriginalFilename());
            CustomFile logo = new CustomFile(logo_fileName, Base64.getEncoder().encodeToString(logo_file.getBytes()));
            CustomFile savedLogo = this.customFileRepository.save(logo);
            club.setLogo(savedLogo);
        }

        if (FSBrequest_file != null) {
            String FSBrequest_fileName = StringUtils.cleanPath(FSBrequest_file.getOriginalFilename());
            CustomFile FSBrequest = new CustomFile(FSBrequest_fileName, Base64.getEncoder().encodeToString(FSBrequest_file.getBytes()));
            CustomFile savedFSBrequest = this.customFileRepository.save(FSBrequest);
            club.setFSBrequest(savedFSBrequest);
        }

        if (UCrequest_file != null) {
            String UCrequest_fileName = StringUtils.cleanPath(UCrequest_file.getOriginalFilename());
            CustomFile UCrequest = new CustomFile(UCrequest_fileName, Base64.getEncoder().encodeToString(UCrequest_file.getBytes()));
            CustomFile savedUCrequest= this.customFileRepository.save(UCrequest);
            club.setUCrequest(savedUCrequest);
        }

        return this.clubRepository.save(club);
    }


    @Override
    public void deleteClub(Long id) throws NotFoundException {
        if(this.clubRepository.existsById(id)) {
            this.clubRepository.deleteById(id);
        }else{
            throw new NotFoundException();
        }
    }

    @Override
    public List<Club> getApprovedClubs() {
        return clubRepository.findAllByLeaderAccountStatusTrue();
    }
}
