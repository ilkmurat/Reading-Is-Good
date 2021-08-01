package com.murat.read.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.murat.read.model.Book;
import com.murat.read.model.CustomerMonthlyStatistics;
import com.murat.read.model.CustomerOrder;
import com.murat.read.model.CustomerOrderItem;
import com.murat.read.repository.CustomerOrderItemRepositoryI;
import com.murat.read.repository.CustomerOrderRepositoryI;

@RestController
@RequestMapping("/read")
@CrossOrigin("*")
public class OrderController {

	@Autowired
	CustomerOrderRepositoryI customerOrderRepo;

	@Autowired
	CustomerOrderItemRepositoryI customerOrderItemRepo;
	
    @RequestMapping(value = "/makeorder", method = RequestMethod.POST)
    public ResponseEntity<Void> orderCreate(@RequestBody CustomerOrderItem customerOrder) {
    	customerOrder.setCdate(new Date());
    	customerOrderItemRepo.save(customerOrder);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

	@GetMapping("/orders")
	public ResponseEntity<List<CustomerOrder>> getAllOrders(@RequestParam(required = true) String userid) {
		try {
			List<CustomerOrder> custOrders = new ArrayList<CustomerOrder>();

			if (userid != null)
				customerOrderRepo.findOrdersByUserId(userid).forEach(custOrders::add);

			if (custOrders.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(custOrders, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public List<CustomerOrderItem> getAllOrderItems(String userid) {
		List<CustomerOrderItem> custOrderItems = new ArrayList<CustomerOrderItem>();
		try {
			if (userid != null)
				customerOrderItemRepo.findOrderItemsByUserId(userid).forEach(custOrderItems::add);

		} catch (Exception e) {

		}
		return custOrderItems;
	}

	public List<CustomerMonthlyStatistics> getStatisticsInfo(String userid) {
		List<CustomerMonthlyStatistics> monthlyInfo = new ArrayList<CustomerMonthlyStatistics>();
		List<CustomerOrderItem> custOrderItems = null;
		int year = Calendar.getInstance().get(Calendar.YEAR);
		try {
			if (userid != null)
				custOrderItems = getAllOrderItems(userid);

			if (custOrderItems != null) {
				int bookCount1 = 0;
				int orderCount1 = 0;
				double totalPrice1 = 0.0;

				int bookCount2 = 0;
				int orderCount2 = 0;
				double totalPrice2 = 0.0;

				int bookCount3 = 0;
				int orderCount3 = 0;
				double totalPrice3 = 0.0;

				int bookCount4 = 0;
				int orderCount4 = 0;
				double totalPrice4 = 0.0;

				int bookCount5 = 0;
				int orderCount5 = 0;
				double totalPrice5 = 0.0;

				int bookCount6 = 0;
				int orderCount6 = 0;
				double totalPrice6 = 0.0;

				int bookCount7 = 0;
				int orderCount7 = 0;
				double totalPrice7 = 0.0;

				int bookCount8 = 0;
				int orderCount8 = 0;
				double totalPrice8 = 0.0;

				int bookCount9 = 0;
				int orderCount9 = 0;
				double totalPrice9 = 0.0;

				int bookCount10 = 0;
				int orderCount10 = 0;
				double totalPrice10 = 0.0;

				int bookCount11 = 0;
				int orderCount11 = 0;
				double totalPrice11 = 0.0;

				int bookCount12 = 0;
				int orderCount12 = 0;
				double totalPrice12 = 0.0;

				CustomerMonthlyStatistics c1 = new CustomerMonthlyStatistics();
				CustomerMonthlyStatistics c2 = new CustomerMonthlyStatistics();
				CustomerMonthlyStatistics c3 = new CustomerMonthlyStatistics();
				CustomerMonthlyStatistics c4 = new CustomerMonthlyStatistics();
				CustomerMonthlyStatistics c5 = new CustomerMonthlyStatistics();
				CustomerMonthlyStatistics c6 = new CustomerMonthlyStatistics();
				CustomerMonthlyStatistics c7 = new CustomerMonthlyStatistics();
				CustomerMonthlyStatistics c8 = new CustomerMonthlyStatistics();
				CustomerMonthlyStatistics c9 = new CustomerMonthlyStatistics();
				CustomerMonthlyStatistics c10 = new CustomerMonthlyStatistics();
				CustomerMonthlyStatistics c11 = new CustomerMonthlyStatistics();
				CustomerMonthlyStatistics c12 = new CustomerMonthlyStatistics();

				for (CustomerOrderItem item : custOrderItems) {
					if (item.getCdate() != null) {
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
						String strDate = formatter.format(item.getCdate());
						String[] parts = strDate.split("-");
						String part1 = parts[0]; // year
						String part2 = parts[1]; // month

						if ((year + "01").equals(part1 + part2)) {
							bookCount1 += item.getCount();
							orderCount1 += 1;
							totalPrice1 += item.getTotalPrice();
							String month = "Jan";
							c1.setMonth(month);
							c1.setTotalBookCount(bookCount1);
							c1.setTotalOrderCount(orderCount1);
							c1.setTotalPurchased(totalPrice1);
						}
						if ((year + "02").equals(part1 + part2)) {
							bookCount2 += item.getCount();
							orderCount2 += 1;
							totalPrice2 += item.getTotalPrice();
							String month = "Feb";
							c2.setMonth(month);
							c2.setTotalBookCount(bookCount2);
							c2.setTotalOrderCount(orderCount2);
							c2.setTotalPurchased(totalPrice2);
						}
						if ((year + "03").equals(part1 + part2)) {
							bookCount3 += item.getCount();
							orderCount3 += 1;
							totalPrice3 += item.getTotalPrice();
							String month = "Mar";
							c3.setMonth(month);
							c3.setTotalBookCount(bookCount3);
							c3.setTotalOrderCount(orderCount3);
							c3.setTotalPurchased(totalPrice3);
						}
						if ((year + "04").equals(part1 + part2)) {
							bookCount4 += item.getCount();
							orderCount4 += 1;
							totalPrice4 += item.getTotalPrice();
							String month = "Apr";
							c4.setMonth(month);
							c4.setTotalBookCount(bookCount4);
							c4.setTotalOrderCount(orderCount4);
							c4.setTotalPurchased(totalPrice4);
						}
						if ((year + "05").equals(part1 + part2)) {
							bookCount5 += item.getCount();
							orderCount5 += 1;
							totalPrice5 += item.getTotalPrice();
							String month = "May";
							c5.setMonth(month);
							c5.setTotalBookCount(bookCount5);
							c5.setTotalOrderCount(orderCount5);
							c5.setTotalPurchased(totalPrice5);
						}
						if ((year + "06").equals(part1 + part2)) {
							bookCount6 += item.getCount();
							orderCount6 += 1;
							totalPrice6 += item.getTotalPrice();
							String month = "Jun";
							c6.setMonth(month);
							c6.setTotalBookCount(bookCount6);
							c6.setTotalOrderCount(orderCount6);
							c6.setTotalPurchased(totalPrice6);
						}
						if ((year + "07").equals(part1 + part2)) {
							bookCount7 += item.getCount();
							orderCount7 += 1;
							totalPrice7 += item.getTotalPrice();
							String month = "Jul";
							c7.setMonth(month);
							c7.setTotalBookCount(bookCount7);
							c7.setTotalOrderCount(orderCount7);
							c7.setTotalPurchased(totalPrice7);
						}
						if ((year + "08").equals(part1 + part2)) {
							bookCount8 += item.getCount();
							orderCount8 += 1;
							totalPrice8 += item.getTotalPrice();
							String month = "Aug";
							c8.setMonth(month);
							c8.setTotalBookCount(bookCount8);
							c8.setTotalOrderCount(orderCount8);
							c8.setTotalPurchased(totalPrice8);
						}
						if ((year + "09").equals(part1 + part2)) {
							bookCount9 += item.getCount();
							orderCount9 += 1;
							totalPrice9 += item.getTotalPrice();
							String month = "Sep";
							c9.setMonth(month);
							c9.setTotalBookCount(bookCount9);
							c9.setTotalOrderCount(orderCount9);
							c9.setTotalPurchased(totalPrice9);
						}
						if ((year + "10").equals(part1 + part2)) {
							bookCount10 += item.getCount();
							orderCount10 += 1;
							totalPrice10 += item.getTotalPrice();
							String month = "Oct";
							c10.setMonth(month);
							c10.setTotalBookCount(bookCount10);
							c10.setTotalOrderCount(orderCount10);
							c10.setTotalPurchased(totalPrice10);
						}
						if ((year + "11").equals(part1 + part2)) {
							bookCount11 += item.getCount();
							orderCount11 += 1;
							totalPrice11 += item.getTotalPrice();
							String month = "Now";
							c11.setMonth(month);
							c11.setTotalBookCount(bookCount11);
							c11.setTotalOrderCount(orderCount11);
							c11.setTotalPurchased(totalPrice11);
						}
						if ((year + "12").equals(part1 + part2)) {
							bookCount12 += item.getCount();
							orderCount12 += 1;
							totalPrice12 += item.getTotalPrice();
							String month = "Dec";
							c12.setMonth(month);
							c12.setTotalBookCount(bookCount12);
							c12.setTotalOrderCount(orderCount12);
							c12.setTotalPurchased(totalPrice12);
						}

					}
				}

				if (c1.getMonth() != null)
					monthlyInfo.add(c1);

				if (c2.getMonth() != null)
					monthlyInfo.add(c2);

				if (c3.getMonth() != null)
					monthlyInfo.add(c3);

				if (c4.getMonth() != null)
					monthlyInfo.add(c4);

				if (c5.getMonth() != null)
					monthlyInfo.add(c5);

				if (c6.getMonth() != null)
					monthlyInfo.add(c6);

				if (c7.getMonth() != null)
					monthlyInfo.add(c7);

				if (c8.getMonth() != null)
					monthlyInfo.add(c8);

				if (c9.getMonth() != null)
					monthlyInfo.add(c9);

				if (c10.getMonth() != null)
					monthlyInfo.add(c10);

				if (c11.getMonth() != null)
					monthlyInfo.add(c11);

				if (c12.getMonth() != null)
					monthlyInfo.add(c12);
			}

		} catch (Exception e) {

		}
		return monthlyInfo;
	}

	@GetMapping("/monthlyinfo")
	public ResponseEntity<List<CustomerMonthlyStatistics>> getCustMonthlyStats(
			@RequestParam(required = true) String userid) {
		try {
			List<CustomerMonthlyStatistics> monthlyInfo = new ArrayList<CustomerMonthlyStatistics>();

			if (userid != null)
				monthlyInfo = getStatisticsInfo(userid);

			if (monthlyInfo.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(monthlyInfo, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
