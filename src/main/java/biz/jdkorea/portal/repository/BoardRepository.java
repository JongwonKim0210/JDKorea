package biz.jdkorea.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

    Board findBoardById(long id);

}
