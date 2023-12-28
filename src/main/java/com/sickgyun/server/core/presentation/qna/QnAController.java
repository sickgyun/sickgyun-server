package com.sickgyun.server.core.presentation.qna;

import com.sickgyun.server.core.presentation.qna.dto.CreateQnARequest;
import com.sickgyun.server.core.service.qna.CommandQnAService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/qna")
public class QnAController {

    private final CommandQnAService commandQnAService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createQnA(@RequestBody CreateQnARequest request) {
        commandQnAService.createQnA(request);
    }
}
