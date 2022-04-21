package ServerProgramming.PhysicalRecordings.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ConditionRepository extends CrudRepository<Condition, Long> {
	List<Condition> findByCondition(String condition);

}
