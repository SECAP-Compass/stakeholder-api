package com.SECAPCompass.stakeholderapi.dao;

import com.SECAPCompass.stakeholderapi.model.Comment;
import com.SECAPCompass.stakeholderapi.model.Stakeholder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("COMMENT")
public class CommentDataAccessService implements CommentDao{

    private static List<Comment> DB = new ArrayList<Comment>();

    @Override
    public int insertComment(UUID id, Comment comment) {
        DB.add(new Comment(id,comment.getCommenterID(),comment.getComment(),comment.getTopicID()));
        return 0;
    }

    @Override
    public Optional<Comment> selectCommentByID(UUID id) {
        return DB.stream()
                .filter(comment -> comment.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteCommentByID(UUID id) {
        Optional<Comment> commentMaybe = selectCommentByID(id);
        if(commentMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(commentMaybe.get());
        return 1;
    }

    @Override
    public int updateCommentByID(UUID id, Comment comment) {
        return selectCommentByID(id)
                .map(c -> {
                    int indexOfComment = DB.indexOf(c);
                    if (indexOfComment >= 0){
                        DB.set(indexOfComment,new Comment(id,comment.getCommenterID(),comment.getComment(),comment.getTopicID()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public List<Comment> selectCommentsByUserID(UUID userID) {
        return DB.stream()
                .filter(comment -> comment.getCommenterID().equals(userID))
                .toList();
    }

    @Override
    public List<Comment> selectCommentsByUserIdAndTopic(UUID userID, UUID topicID) {
        return DB.stream()
                .filter(comment1 -> comment1.getCommenterID().equals(userID))
                .filter(comment2 -> comment2.getTopicID().equals(topicID))
                .toList();
    }
}
