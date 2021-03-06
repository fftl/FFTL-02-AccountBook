package fftl.fftl02backSpring.service;

import fftl.fftl02backSpring.entity.Comment;
import fftl.fftl02backSpring.repository.CommentRepository;
import fftl.fftl02backSpring.request.SaveCommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public boolean saveComment(SaveCommentDto saveCommentDto){
        Comment comment = commentRepository.save(saveCommentDto.toEntity());

        if(comment != null){
            return true;
        }
        return false;
    }

    public List<Comment> getAllComments(Long bid){
        List<Comment> comments = commentRepository.findByBid(bid);
        return comments;
    }

    public void deleteComment(Long cid){
        Comment comment = commentRepository.findById(cid).orElseThrow();
        commentRepository.delete(comment);
    }
}
