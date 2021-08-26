package ports.repository;

import utils.PageInfo;
import utils.Pagination;

import java.util.Optional;
import java.util.Set;

public interface ScheduleRepository<Schedule, String> {
    PageInfo<Schedule> findAll(Pagination pagination);
    Set<Schedule> findByTitleAndContentWithLike(String name, String content);
    Optional<Schedule> find(String id);
    void save(Schedule entity);
    void update(Schedule entity);
    void delete(String id);
}
