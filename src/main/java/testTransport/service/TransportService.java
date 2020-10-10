package testTransport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testTransport.model.Transport;
import testTransport.repository.TransportRepository;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Transactional
@Service
public class TransportService {

  @Autowired
  TransportRepository transportRepository;

  public List<Transport> listAll(){
    List<Transport> list = new ArrayList<>();
    transportRepository.findAll().forEach(list::add);
    list.sort(Comparator.comparing(Transport::getId));
    return list;
  }

  public Transport createTransport(Transport transport) {
    return transportRepository.save(transport);
  }

  public void deleteTransport(Integer id) {
    transportRepository.deleteById(id);
  }

  public void saveTransport(Transport transport) {
    transportRepository.save(transport);
  }


  public Transport getTransport(Integer i) {
    return transportRepository.findById(i).orElseThrow(EntityExistsException::new);
  }

  public List<Transport> listBikes() {
    return transportRepository.findAllBikeWithPrice();
  }
}
