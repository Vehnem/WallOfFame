package org.dbpedia.walloffame.spring.controller

import org.dbpedia.walloffame.Config
import org.dbpedia.walloffame.convert.ModelToJSONConverter
import org.dbpedia.walloffame.virtuoso.VirtuosoHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod.GET


@Controller
class WoFController {

  @Autowired
  private var config: Config = _

  @RequestMapping(value = Array("/walloffame"), method = Array(GET))
  def getIndexPage(): String = {
    ModelToJSONConverter.toJSON(VirtuosoHandler.getModel(config.virtuoso))
    "redirect:static/exhibit/walloffame.html"
  }

}
