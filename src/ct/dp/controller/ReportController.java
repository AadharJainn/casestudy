package ct.dp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import ct.dp.business.bean.BillRangeBean;
import ct.dp.business.bean.PizzaOrderBean;
import ct.dp.service.PizzaService;

@Controller
public class ReportController {

	@Autowired
	PizzaService pizzaService;
	@RequestMapping(path = "/loadrange", method = RequestMethod.POST)
	public ModelAndView loadDateRangeReportPage() {
		ModelAndView loadDateModel = new ModelAndView();
		BillRangeBean billRangeBill = new BillRangeBean();
		loadDateModel.addObject("billRange", billRangeBill);
		loadDateModel.setViewName("OrderReport");
		return loadDateModel;
	}

	@RequestMapping(path = "/getdetails", method = RequestMethod.POST)
	public ModelAndView getOrderDetails(@ModelAttribute("billRangeBean") BillRangeBean billRangeBean) {
		ModelAndView getOrderModel = new ModelAndView();
		Double fromRange = billRangeBean.getFromPrice();
		Double toRange = billRangeBean.getToPrice();
		List<PizzaOrderBean> billDetails = pizzaService.getOrderDetails(fromRange, toRange);
		getOrderModel.addObject("billDetails",billDetails);
		getOrderModel.setViewName("OrderReport");
		return getOrderModel;
	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = Exception.class)
	public ModelAndView handleAllException() {
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("secondError", "No records were found for the entered bill range!");
		modelandview.setViewName(" GeneralizedExceptionHandlerPage");
		return modelandview;
	}

}
