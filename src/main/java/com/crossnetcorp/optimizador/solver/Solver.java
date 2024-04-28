package com.crossnetcorp.optimizador.solver;

import com.crossnetcorp.optimizador.domain.VehicleRoutePlan;

import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import ai.timefold.solver.core.api.score.analysis.ScoreAnalysis;
import ai.timefold.solver.core.api.score.buildin.hardsoftlong.HardSoftLongScore;
import ai.timefold.solver.core.api.solver.RecommendedFit;
import ai.timefold.solver.core.api.solver.ScoreAnalysisFetchPolicy;
import ai.timefold.solver.core.api.solver.SolutionManager;
import ai.timefold.solver.core.api.solver.SolverManager;
import ai.timefold.solver.core.api.solver.SolverStatus;
import ai.timefold.solver.core.api.solver.SolverFactory;
import ai.timefold.solver.core.config.solver.SolverConfig;

import com.crossnetcorp.optimizador.domain.*;
import com.crossnetcorp.optimizador.solver.*;

public class Solver {
	//private final SolverManager<VehicleRoutePlan, String> solverManager;
	//private final SolutionManager<VehicleRoutePlan, HardSoftLongScore> solutionManager;

	private final SolverFactory<VehicleRoutePlan> solverFactory;

	private final ConcurrentMap<String, Job> jobIdToJob = new ConcurrentHashMap<>();

	public Solver() {	
		this.solverFactory = SolverFactory.create(
				new SolverConfig()
				.withSolutionClass(VehicleRoutePlan.class)
				.withEntityClasses(Vehicle.class, Visit.class)
				.withConstraintProviderClass(VehicleRoutingConstraintProvider.class)
				// The solver runs only for 2 seconds on this tiny dataset.
				// // It's recommended to run for at least 5 minutes ("5m") on large datasets.
				.withTerminationSpentLimit(Duration.ofSeconds(2)));

		//this.solverManager = new SolverManager<>();
		//this.solutionManager = new SolutionManager<>();
	}

	public VehicleRoutePlan solve(VehicleRoutePlan problem) {
		String jobId = UUID.randomUUID().toString();
		jobIdToJob.put(jobId, Job.ofRoutePlan(problem));

		//solverManager.solveBuilder()
		//	.withProblemId(jobId)
		//       	.withProblemFinder(jobId_ -> jobIdToJob.get(jobId).routePlan)
		//	.withBestSolutionConsumer(solution -> jobIdToJob.put(jobId, Job.ofRoutePlan(solution)))
		//	.withExceptionHandler((jobId_, exception) -> {
		//		jobIdToJob.put(jobId, Job.ofException(exception));
		//		//LOGGER.error("Failed solving jobId ({}).", jobId, exception);
		//	})
		//        .run();
		return jobIdToJob.get(jobId).routePlan;
	}

	private record Job(VehicleRoutePlan routePlan, Throwable exception) {
		static Job ofRoutePlan(VehicleRoutePlan routePlan) {
			return new Job(routePlan, null);
		}
		
		static Job ofException(Throwable exception) {
			return new Job(null, exception);
		}
	}

}
