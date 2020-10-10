package testTransport.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import testTransport.model.Transport;
import testTransport.service.TransportService;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value = "/api", description = "Транспорт")
public class TransportController {

  @Autowired
  TransportService transportService;

  @ResponseBody
  @PostMapping(value = "/transport/add")
  @ApiOperation("Додавання нового транспорту")
  public Transport createTransportByPerson(@RequestBody Transport transport) {
    return transportService.createTransport(transport);
  }

  @ResponseStatus(HttpStatus.OK)
  @DeleteMapping(value = "/transport/{id}/delete")
  @ApiOperation("Видалення транспорту")
  public void deleteTransport(@PathVariable Integer id) {
    transportService.deleteTransport(id);
  }

  @SneakyThrows
  @ResponseBody
  @PostMapping(value = "/transport/{id}/edit")
  @ApiOperation("Зміна вже існуючого транспорту")
  public Transport editTransport(@RequestBody Transport transport, @PathVariable Integer id) {
    transport.setId(id);
    transportService.saveTransport(transport);
    return transportService.getTransport(id);
  }

  @ResponseBody
  @RequestMapping(value = "/transport/all", method = RequestMethod.GET)
  @ApiOperation("Список всього транспорту")
  public List<Transport> getTransportList() {
    return transportService.listAll();
  }

  @ResponseBody
  @RequestMapping(value = "/transport/search/bike", method = RequestMethod.GET)
  @ApiOperation("Список лише мотоциклів, ціна яких більша за 1000")
  public List<Transport> getBikes() {
    return transportService.listBikes();
  }

}
