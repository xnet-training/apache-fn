package com.crossnetcorp.fn;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import java.time.Duration;

import com.crossnetcorp.optimizador.domain.VehicleRoutePlan;
import com.crossnetcorp.optimizador.domain.Location;
import com.crossnetcorp.optimizador.domain.Vehicle;
import com.crossnetcorp.optimizador.domain.Visit;

import com.crossnetcorp.optimizador.solver.VRMSolver;

public class OptaFunction {

    public Output handleRequest(Input input) {
	    System.out.println("Iniciando");
	    System.out.println(input);

	    VRMSolver solver = new VRMSolver();
	    return translateFromSolution(solver.solve(translateToProblem(input)));

	    // String problem = (input == null || input.isEmpty()) ? "{'problem': {}}"  : input;
	    // System.out.println("Optimizando problema"); 
	    // return "{ 'result': {" + problem + "}";
    }

    private Output translateFromSolution(VehicleRoutePlan solution) {
	    Output results = new Output("Demo");
	    results.routes = new ArrayList<OutputRoute>();
	    solution.getVehicles().stream()
		    .filter(v -> v.getVisits().size() > 0)
		    .forEach(v -> translateToRoute(v));
	    return results;
    }

    private VehicleRoutePlan translateToProblem(Input input) {
	    List<Vehicle> vehicles = new ArrayList<>();
	    List<Visit> visits = new ArrayList<>();
	    return new VehicleRoutePlan(
			    "problem1",
			    new Location(0,0),
			    new Location(0,0),
			    null,
			    null,
			    translateVehicleFromProblem(input.fleet),
			    translateVisitFromProblem(input.visits)
			   );
    }

    private List<Vehicle> translateVehicleFromProblem(List<InputVehicle> vehicles) {
	    List<Vehicle> items = new ArrayList<>();
	    vehicles.stream().forEach(v -> items.add(translateVehicle(v)));
	    return items;
    }

    private List<Visit> translateVisitFromProblem(List<InputVisit> visits) {
	    List<Visit> items = new ArrayList<>();
	    visits.stream().forEach(v -> items.add(translateVisit(v)));
	    return items;
    }

    private Visit translateVisit(InputVisit visit) {
	    return new Visit(
		"V001",
		"V001",
		new Location(0,0),
		10,
		LocalDateTime.now(),
		LocalDateTime.now(),
		Duration.ofSeconds(300)
	   );
    }

    private Vehicle translateVehicle(InputVehicle vehicle) {
	return new Vehicle(
		"V01",
		1000,
		new Location(0,0),
		LocalDateTime.now()
	);
    }

    private OutputRoute translateToRoute(Vehicle vehicle) {
        return new OutputRoute(vehicle.getId(), 
			vehicle.getVisits().stream().map(v -> translateToVisit(v)).toList());
    }

    private OutputVisit translateToVisit(Visit visit) {
	    return new OutputVisit(
			    visit.getId(),
			    visit.getLocation().getLatitude(),
			    visit.getLocation().getLongitude(),
			    visit.getArrivalTime(),
			    null);
    }
}
