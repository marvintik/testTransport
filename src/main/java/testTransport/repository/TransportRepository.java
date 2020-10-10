package testTransport.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import testTransport.model.Transport;

import java.util.List;

@Repository
public interface TransportRepository extends CrudRepository<Transport, Integer> {

  @Query("select t from Transport t where t.typeTransport = testTransport.model.TypeTransport.BIKE and t.price > 1000")
  public List<Transport> findAllBikeWithPrice();
}
