package coms309.demo2.repository;
import coms309.demo2.model.CalendarEvent;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CalendarRepository extends JpaRepository<CalendarEvent, Long> {

}
