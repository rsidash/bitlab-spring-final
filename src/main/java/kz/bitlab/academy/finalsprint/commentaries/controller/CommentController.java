package kz.bitlab.academy.finalsprint.commentaries.controller;

import kz.bitlab.academy.finalsprint.commentaries.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/tasks/{taskId}/edit/add-comment")
    public String addComment(@PathVariable Long taskId,
                             @RequestParam("comment") String comment) {
        commentService.create(comment, taskId);

        return "redirect:/tasks/" + taskId + "/edit";
    }
}
