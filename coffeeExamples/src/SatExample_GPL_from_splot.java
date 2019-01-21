//Java imports
import java.util.HashMap;
import java.util.List;
//imports for hlcl 
import com.variamos.hlcl.core.HlclProgram; 
import com.variamos.hlcl.model.expressions.HlclFactory; 
import com.variamos.hlcl.model.domains.BinaryDomain;
import com.variamos.hlcl.model.domains.IntervalDomain;
import com.variamos.hlcl.model.domains.RangeDomain;
import com.variamos.hlcl.model.domains.StringDomain;
import com.variamos.hlcl.model.expressions.Identifier;
import com.variamos.hlcl.model.expressions.IntBooleanExpression;
import com.variamos.hlcl.model.expressions.NumericIdentifier;
import com.variamos.hlcl.model.expressions.SymbolicExpression;
import com.variamos.hlcl.model.expressions.IntNumericExpression;

//imports for solver
import com.variamos.solver.core.SWIPrologSolver;
import com.variamos.solver.core.compiler.Hlcl2SWIProlog;
import com.variamos.solver.model.SolverSolution;

/**
* This class is automatically generated from a product line model described in 
* constraint programming HLCL
* @author Angela Villota 
* @version CP-HLCL Version1
*
*/
public class SatExample_GPL_from_splot { 			
	
	private String modelName;
	private HlclFactory factory;
	private HlclProgram hlclProgram;
	private SWIPrologSolver swiSolver;
	private String prologProgram;
	private HashMap<String,IntBooleanExpression> constraints;
	private HashMap<String,Identifier> variables;
	private HashMap<String,NumericIdentifier> numbers;
	/**
	* This is an autogenerated method* Constructor method
	* @param modelName is the name of the model in the  CP-HLCL specification
	*/
	public SatExample_GPL_from_splot(String modelName){ 				
		
		this.modelName= modelName;
		hlclProgram= new HlclProgram();
		factory = new HlclFactory();
		variables= new HashMap<String,Identifier>();
		constraints= new HashMap<String,IntBooleanExpression>();
		numbers= new HashMap<String,NumericIdentifier>();
		NumericIdentifier one = factory.number(1);
		NumericIdentifier zero= factory.number(0);
		numbers.put("1", one);
		numbers.put("0", zero);
	} 			
	public static void main(String[] args) {
		SatExample_GPL_from_splot obj = new SatExample_GPL_from_splot("SatExample_GPL_from_splot");
		obj.run();
	}
	public void run(){
		// first obtain a HlclProgram from the specification
		transformVars();
		transformConstraints(); 
		// use the solver to solve the constraint program
		System.out.println(prologProgram);
		evaluateSatisfiability();
		//show the output
		System.out.println(prologProgram);
	}
	public void transformVars() {
//declaring variable Gpl
Identifier Gpl = factory.newIdentifier("Gpl");
  			BinaryDomain GplDom= new BinaryDomain();
Gpl.setDomain(GplDom);	
variables.put("Gpl", Gpl); //including the variable in the map
//declaring variable Weight
Identifier Weight = factory.newIdentifier("Weight");
  			BinaryDomain WeightDom= new BinaryDomain();
Weight.setDomain(WeightDom);	
variables.put("Weight", Weight); //including the variable in the map
//declaring variable weighted
Identifier weighted = factory.newIdentifier("weighted");
  			BinaryDomain weightedDom= new BinaryDomain();
weighted.setDomain(weightedDom);	
variables.put("weighted", weighted); //including the variable in the map
//declaring variable unweighted
Identifier unweighted = factory.newIdentifier("unweighted");
  			BinaryDomain unweightedDom= new BinaryDomain();
unweighted.setDomain(unweightedDom);	
variables.put("unweighted", unweighted); //including the variable in the map
//declaring variable Gtp
Identifier Gtp = factory.newIdentifier("Gtp");
  			BinaryDomain GtpDom= new BinaryDomain();
Gtp.setDomain(GtpDom);	
variables.put("Gtp", Gtp); //including the variable in the map
//declaring variable directed
Identifier directed = factory.newIdentifier("directed");
  			BinaryDomain directedDom= new BinaryDomain();
directed.setDomain(directedDom);	
variables.put("directed", directed); //including the variable in the map
//declaring variable undirected
Identifier undirected = factory.newIdentifier("undirected");
  			BinaryDomain undirectedDom= new BinaryDomain();
undirected.setDomain(undirectedDom);	
variables.put("undirected", undirected); //including the variable in the map
//declaring variable Search
Identifier Search = factory.newIdentifier("Search");
  			BinaryDomain SearchDom= new BinaryDomain();
Search.setDomain(SearchDom);	
variables.put("Search", Search); //including the variable in the map
//declaring variable DFS
Identifier DFS = factory.newIdentifier("DFS");
  			BinaryDomain DFSDom= new BinaryDomain();
DFS.setDomain(DFSDom);	
variables.put("DFS", DFS); //including the variable in the map
//declaring variable BFS
Identifier BFS = factory.newIdentifier("BFS");
  			BinaryDomain BFSDom= new BinaryDomain();
BFS.setDomain(BFSDom);	
variables.put("BFS", BFS); //including the variable in the map
//declaring variable Algorithms
Identifier Algorithms = factory.newIdentifier("Algorithms");
  			BinaryDomain AlgorithmsDom= new BinaryDomain();
Algorithms.setDomain(AlgorithmsDom);	
variables.put("Algorithms", Algorithms); //including the variable in the map
//declaring variable connected
Identifier connected = factory.newIdentifier("connected");
  			BinaryDomain connectedDom= new BinaryDomain();
connected.setDomain(connectedDom);	
variables.put("connected", connected); //including the variable in the map
//declaring variable stronglyc
Identifier stronglyc = factory.newIdentifier("stronglyc");
  			BinaryDomain stronglycDom= new BinaryDomain();
stronglyc.setDomain(stronglycDom);	
variables.put("stronglyc", stronglyc); //including the variable in the map
//declaring variable cycle
Identifier cycle = factory.newIdentifier("cycle");
  			BinaryDomain cycleDom= new BinaryDomain();
cycle.setDomain(cycleDom);	
variables.put("cycle", cycle); //including the variable in the map
//declaring variable mstprim
Identifier mstprim = factory.newIdentifier("mstprim");
  			BinaryDomain mstprimDom= new BinaryDomain();
mstprim.setDomain(mstprimDom);	
variables.put("mstprim", mstprim); //including the variable in the map
//declaring variable mstkruskal
Identifier mstkruskal = factory.newIdentifier("mstkruskal");
  			BinaryDomain mstkruskalDom= new BinaryDomain();
mstkruskal.setDomain(mstkruskalDom);	
variables.put("mstkruskal", mstkruskal); //including the variable in the map
//declaring variable shortest
Identifier shortest = factory.newIdentifier("shortest");
  			BinaryDomain shortestDom= new BinaryDomain();
shortest.setDomain(shortestDom);	
variables.put("shortest", shortest); //including the variable in the map
	}
	public void transformConstraints() {
//
//declaring constraint c0


Identifier c0_left = variables.get("Gpl");

NumericIdentifier c0_right = getValue("1");
IntBooleanExpression c0=
factory.equals(c0_left, c0_right);
constraints.put("c0", c0);
hlclProgram.add(c0);
//
//declaring constraint c2


Identifier c2_left = variables.get("Gpl");

Identifier c2_right = variables.get("Algorithms");
IntBooleanExpression c2=factory.doubleImplies(c2_left, c2_right);		
constraints.put("c2", c2);
hlclProgram.add(c2);
//
//declaring constraint c4


Identifier c4_left = variables.get("Gpl");

Identifier c4_right = variables.get("Gtp");
IntBooleanExpression c4=factory.doubleImplies(c4_left, c4_right);		
constraints.put("c4", c4);
hlclProgram.add(c4);
//
//declaring constraint C3


Identifier C3_left = variables.get("Weight");

Identifier C3_right = variables.get("Gpl");
IntBooleanExpression C3=factory.implies(C3_left, C3_right);		
constraints.put("C3", C3);
hlclProgram.add(C3);
//
//declaring constraint c5


Identifier c5_left = variables.get("Search");

Identifier c5_right = variables.get("Gpl");
IntBooleanExpression c5=factory.implies(c5_left, c5_right);		
constraints.put("c5", c5);
hlclProgram.add(c5);
//
//declaring constraint c6



Identifier c6_negation_left = variables.get("stronglyc");

Identifier c6_negation_right = variables.get("shortest");
IntBooleanExpression c6_negation=factory.and(c6_negation_left, c6_negation_right);		
IntBooleanExpression c6=factory.not(c6_negation);
constraints.put("c6", c6);
hlclProgram.add(c6);
//
//declaring constraint c7



Identifier c7_negation_left = variables.get("mstprim");

Identifier c7_negation_right = variables.get("mstkruskal");
IntBooleanExpression c7_negation=factory.and(c7_negation_left, c7_negation_right);		
IntBooleanExpression c7=factory.not(c7_negation);
constraints.put("c7", c7);
hlclProgram.add(c7);
//
//declaring constraint c8



Identifier c8_negation_left = variables.get("connected");

Identifier c8_negation_right = variables.get("stronglyc");
IntBooleanExpression c8_negation=factory.and(c8_negation_left, c8_negation_right);		
IntBooleanExpression c8=factory.not(c8_negation);
constraints.put("c8", c8);
hlclProgram.add(c8);
//
//declaring constraint c9



Identifier c9_negation_left = variables.get("mstkruskal");

Identifier c9_negation_right = variables.get("shortest");
IntBooleanExpression c9_negation=factory.and(c9_negation_left, c9_negation_right);		
IntBooleanExpression c9=factory.not(c9_negation);
constraints.put("c9", c9);
hlclProgram.add(c9);
//
//declaring constraint c10



Identifier c10_negation_left = variables.get("mstprim");

Identifier c10_negation_right = variables.get("shortest");
IntBooleanExpression c10_negation=factory.and(c10_negation_left, c10_negation_right);		
IntBooleanExpression c10=factory.not(c10_negation);
constraints.put("c10", c10);
hlclProgram.add(c10);
//
//declaring constraint c11


Identifier c11_left = variables.get("mstprim");

Identifier c11_right = variables.get("unweighted");
IntBooleanExpression c11=factory.implies(c11_left, c11_right);		
constraints.put("c11", c11);
hlclProgram.add(c11);
//
//declaring constraint c12


Identifier c12_left = variables.get("mstprim");

Identifier c12_right = variables.get("undirected");
IntBooleanExpression c12=factory.implies(c12_left, c12_right);		
constraints.put("c12", c12);
hlclProgram.add(c12);
//
//declaring constraint c13


Identifier c13_left = variables.get("shortest");

Identifier c13_right = variables.get("directed");
IntBooleanExpression c13=factory.implies(c13_left, c13_right);		
constraints.put("c13", c13);
hlclProgram.add(c13);
//
//declaring constraint c14


Identifier c14_left = variables.get("mstkruskal");

Identifier c14_right = variables.get("unweighted");
IntBooleanExpression c14=factory.implies(c14_left, c14_right);		
constraints.put("c14", c14);
hlclProgram.add(c14);
//
//declaring constraint c15


Identifier c15_left = variables.get("stronglyc");

Identifier c15_right = variables.get("undirected");
IntBooleanExpression c15=factory.implies(c15_left, c15_right);		
constraints.put("c15", c15);
hlclProgram.add(c15);
//
//declaring constraint c16


Identifier c16_left = variables.get("connected");

Identifier c16_right = variables.get("Search");
IntBooleanExpression c16=factory.implies(c16_left, c16_right);		
constraints.put("c16", c16);
hlclProgram.add(c16);
//
//declaring constraint c17


Identifier c17_left = variables.get("mstkruskal");

Identifier c17_right = variables.get("undirected");
IntBooleanExpression c17=factory.implies(c17_left, c17_right);		
constraints.put("c17", c17);
hlclProgram.add(c17);
//
//declaring constraint c18


Identifier c18_left = variables.get("cycle");

Identifier c18_right = variables.get("DFS");
IntBooleanExpression c18=factory.implies(c18_left, c18_right);		
constraints.put("c18", c18);
hlclProgram.add(c18);
//
//declaring constraint c19



Identifier c19_left_left = variables.get("directed");



Identifier c19_left_right_left_negation = variables.get("undirected");
IntBooleanExpression c19_left_right_left=factory.not(c19_left_right_left_negation);

Identifier c19_left_right_right = variables.get("Gtp");
IntBooleanExpression c19_left_right=factory.and(c19_left_right_left, c19_left_right_right);		
IntBooleanExpression c19_left=factory.doubleImplies(c19_left_left, c19_left_right);		


Identifier c19_right_left = variables.get("undirected");



Identifier c19_right_right_left_negation = variables.get("directed");
IntBooleanExpression c19_right_right_left=factory.not(c19_right_right_left_negation);

Identifier c19_right_right_right = variables.get("Gtp");
IntBooleanExpression c19_right_right=factory.and(c19_right_right_left, c19_right_right_right);		
IntBooleanExpression c19_right=factory.doubleImplies(c19_right_left, c19_right_right);		
IntBooleanExpression c19=factory.and(c19_left, c19_right);		
constraints.put("c19", c19);
hlclProgram.add(c19);
//
//declaring constraint c20


Identifier c20_left = variables.get("Algorithms");






Identifier c20_right_left_left_left_left_left = variables.get("connected");

Identifier c20_right_left_left_left_left_right = variables.get("stronglyc");
IntBooleanExpression c20_right_left_left_left_left=factory.or(c20_right_left_left_left_left_left, c20_right_left_left_left_left_right);		

Identifier c20_right_left_left_left_right = variables.get("cycle");
IntBooleanExpression c20_right_left_left_left=factory.or(c20_right_left_left_left_left, c20_right_left_left_left_right);		

Identifier c20_right_left_left_right = variables.get("mstprim");
IntBooleanExpression c20_right_left_left=factory.or(c20_right_left_left_left, c20_right_left_left_right);		

Identifier c20_right_left_right = variables.get("mstkruskal");
IntBooleanExpression c20_right_left=factory.or(c20_right_left_left, c20_right_left_right);		

Identifier c20_right_right = variables.get("shortest");
IntBooleanExpression c20_right=factory.or(c20_right_left, c20_right_right);		
IntBooleanExpression c20=factory.doubleImplies(c20_left, c20_right);		
constraints.put("c20", c20);
hlclProgram.add(c20);
//
//declaring constraint c21



Identifier c21_left_left = variables.get("weighted");



Identifier c21_left_right_left_negation = variables.get("unweighted");
IntBooleanExpression c21_left_right_left=factory.not(c21_left_right_left_negation);

Identifier c21_left_right_right = variables.get("Weight");
IntBooleanExpression c21_left_right=factory.and(c21_left_right_left, c21_left_right_right);		
IntBooleanExpression c21_left=factory.doubleImplies(c21_left_left, c21_left_right);		


Identifier c21_right_left = variables.get("unweighted");



Identifier c21_right_right_left_negation = variables.get("weighted");
IntBooleanExpression c21_right_right_left=factory.not(c21_right_right_left_negation);

Identifier c21_right_right_right = variables.get("Weight");
IntBooleanExpression c21_right_right=factory.and(c21_right_right_left, c21_right_right_right);		
IntBooleanExpression c21_right=factory.doubleImplies(c21_right_left, c21_right_right);		
IntBooleanExpression c21=factory.and(c21_left, c21_right);		
constraints.put("c21", c21);
hlclProgram.add(c21);
//
//declaring constraint c22



Identifier c22_left_left = variables.get("BFS");



Identifier c22_left_right_left_negation = variables.get("DFS");
IntBooleanExpression c22_left_right_left=factory.not(c22_left_right_left_negation);

Identifier c22_left_right_right = variables.get("Search");
IntBooleanExpression c22_left_right=factory.and(c22_left_right_left, c22_left_right_right);		
IntBooleanExpression c22_left=factory.doubleImplies(c22_left_left, c22_left_right);		


Identifier c22_right_left = variables.get("DFS");



Identifier c22_right_right_left_negation = variables.get("BFS");
IntBooleanExpression c22_right_right_left=factory.not(c22_right_right_left_negation);

Identifier c22_right_right_right = variables.get("Search");
IntBooleanExpression c22_right_right=factory.and(c22_right_right_left, c22_right_right_right);		
IntBooleanExpression c22_right=factory.doubleImplies(c22_right_left, c22_right_right);		
IntBooleanExpression c22=factory.and(c22_left, c22_right);		
constraints.put("c22", c22);
hlclProgram.add(c22);
	}
	public boolean evaluateSatisfiability(){
		// the output
		boolean evaluation= false;
		// //to transform the hllcl program into a prolog  file, 
		// //these lines are commented because they are useful for debugging 
		Hlcl2SWIProlog swiPrologTransformer = new Hlcl2SWIProlog(); 
		prologProgram = swiPrologTransformer.transform(hlclProgram);
		System.out.println(prologProgram);
		// an instance of the solver for Swiprolog 
		swiSolver= new SWIPrologSolver();
		swiSolver.setHLCLProgram(hlclProgram); //passing the hlcl program to the solver
		swiSolver.solve(); // This methhod prepares the solver 
		List<SolverSolution> solutions = swiSolver.getAllSolutions(); // Consulting if the solver has one solution
			evaluation= solutions.size()>0;
			for (SolverSolution solverSolution : solutions) {
				System.out.println(solverSolution.toString());
			}	return evaluation;
	}
	/** 
	* To obtain the NumericIdentifier representation of a value 
	* @param id the string with the value 
	* @return the NumericIdentifier 
	*/
	public NumericIdentifier getValue(String id) {	NumericIdentifier value= numbers.get(id); 
	 	if (value==null) { 
	 		if (id.equals("selected")) { 
	 			value= numbers.get("1"); 
	 		} 
	 		else if(id.equals("unselected")) {
				value= numbers.get("0"); 
			} 
			else { 
				value= factory.number(Integer.parseInt(id)); 
				numbers.put(id, value);
			}
	 	} 
	 	return value; 
	 } 
		public String getModelName() {
			return modelName;
		}
		public void setModelName(String modelName) {
			this.modelName = modelName;
		}
		public HlclFactory getFactory() {
			return factory;
		}
		public void setFactory(HlclFactory factory) {
			this.factory = factory;
		}
		public HlclProgram getHlclProgram() {
			return hlclProgram;
		}
		public void setHlclProgram(HlclProgram hlclProgram) {
			this.hlclProgram = hlclProgram;
		}
} 	