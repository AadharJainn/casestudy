package ct.dp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import ct.dp.business.bean.PizzaOrderBean;
import ct.dp.service.PizzaService;

@Controller
public class PizzaOrderController {

	@Autowired
	PizzaService pizzaService;

	public ModelAndView loadSavePizza() {
		PizzaOrderBean pizzaOrderBean = new PizzaOrderBean();
		ModelAndView loadModel = new ModelAndView();
		loadModel.addObject("getPizzaOrder", pizzaOrderBean);
		loadModel.setViewName("PizzaOrder");
		return loadModel;
	}

	public ModelAndView saveCustomer() {
		ModelAndView saveModel = new ModelAndView();
		return saveModel;
	}

	public Map<Integer, String> populatePizzaNames() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map = pizzaService.findAllPizzaDetails();
		return map;
	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = Exception.class)
	public ModelAndView handleAllException() {
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("error", "exception occured!");
		modelandview.setViewName(" GeneralizedExceptionHandlerPage");

		return modelandview;
	}

}
