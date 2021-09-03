package ct.dp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import ct.dp.business.bean.PizzaOrderBean;
import ct.dp.service.PizzaService;

@Controller
public class PizzaOrderController {

	@Autowired
	PizzaService pizzaService;

	@RequestMapping("/load")
	public ModelAndView loadSavePizza() {
		PizzaOrderBean pizzaOrderBean = new PizzaOrderBean();
		ModelAndView loadModel = new ModelAndView();
		loadModel.addObject("getPizzaOrder", pizzaOrderBean);
		loadModel.setViewName("PizzaOrder");
		return loadModel;
	}

	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public ModelAndView addPizzaOrderDetails(@ModelAttribute("pizzaOrderBean") PizzaOrderBean pizzaOrderBean,
			BindingResult bindingResult) {
		ModelAndView saveModel = new ModelAndView();
		if (bindingResult.hasErrors()) {
			saveModel.setViewName("PizzaOrder");
			return saveModel;
		}
		Integer orderId = pizzaService.addPizzaOrderDetails(pizzaOrderBean).getOrderId();
		Double bill = pizzaService.addPizzaOrderDetails(pizzaOrderBean).getBill();
		saveModel.addObject(bill);
		saveModel.addObject(orderId);
		saveModel.addObject("success", "Add Pizza Order Details Success");
		saveModel.setViewName("PizzaOrderSuccess");
		return saveModel;
	}

	public Map<Integer, String> populatePizzaNames() {
		Map<Integer, String> map = pizzaService.findAllPizzaDetails();
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
