package gr.codelearn.core.showcase.oop.bike.service;

import gr.codelearn.core.showcase.oop.bike.domain.Bike;

public interface Transmission {
	void gearUp(Bike bike);

	void gearDown(Bike bike);

	void chainRingUp(Bike bike);

	void chainRingDown(Bike bike);
}
