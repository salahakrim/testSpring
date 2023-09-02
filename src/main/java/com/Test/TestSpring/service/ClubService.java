package com.Test.TestSpring.service;

import com.Test.TestSpring.dto.ClubDto;
import com.Test.TestSpring.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();

    Club saveClub(ClubDto clubDto);

    ClubDto findClubById(long clubId);

    void updateClub(ClubDto club);
}
