package com.example.hanghae99_mini2.controller;

import com.example.hanghae99_mini2.domain.Timestamped;
import com.example.hanghae99_mini2.dto.StudyRegisterDto;
import com.example.hanghae99_mini2.dto.StudyUpdateDto;
import com.example.hanghae99_mini2.model.Study;
import com.example.hanghae99_mini2.security.UserDetailsImpl;
import com.example.hanghae99_mini2.service.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class StudyController extends Timestamped {
    // Timestamped 상속하여 createdAt, modifiedAt 필드 사용가능
    private final StudyService studyService;

    // Study 생성
    @PostMapping("/board/write/{userId}")
    public Study createStudy(@RequestBody StudyRegisterDto requestDto,
                             @PathVariable Long userId){
        return studyService.createStudy(requestDto, userId);
    }

    // Study 업데이트
    @PutMapping("/board/{id}/update")
    public Study updateStudy(@PathVariable Long id, @RequestBody StudyUpdateDto requestDto) {
        return studyService.updateStudy(id, requestDto);
    }

    // Study 삭제
    @DeleteMapping("/board/{id}/delete")
    public void deleteStudy(@PathVariable Long id) {
        studyService.deleteStudy(id);
    }
}