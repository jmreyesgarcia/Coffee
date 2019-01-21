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
public class Ex4_MCS { 			
	
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
	public Ex4_MCS(String modelName){ 				
		
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
		Ex4_MCS obj = new Ex4_MCS("Ex4_MCS");
		obj.run();
	}
	public void run(){
		// first obtain a HlclProgram from the specification
		transformVars();
		transformConstraints(); 
		// use the solver to solve the constraint program
		evaluateSatisfiability();
		//show the output
		System.out.println(prologProgram);
	}
	public void transformVars() {
//declaring variable Processor
Identifier Processor = factory.newIdentifier("Processor");
  			BinaryDomain ProcessorDom= new BinaryDomain();
Processor.setDomain(ProcessorDom);	
variables.put("Processor", Processor); //including the variable in the map
//declaring variable Processor_card
Identifier Processor_card = factory.newIdentifier("Processor_card");
 				RangeDomain Processor_cardDom= new RangeDomain(1, 2);
Processor_card.setDomain(Processor_cardDom);	
variables.put("Processor_card", Processor_card); //including the variable in the map
//declaring variable MCS_Processor1
Identifier MCS_Processor1 = factory.newIdentifier("MCS_Processor1");
  			BinaryDomain MCS_Processor1Dom= new BinaryDomain();
MCS_Processor1.setDomain(MCS_Processor1Dom);	
variables.put("MCS_Processor1", MCS_Processor1); //including the variable in the map
//declaring variable MCS_Processor2
Identifier MCS_Processor2 = factory.newIdentifier("MCS_Processor2");
  			BinaryDomain MCS_Processor2Dom= new BinaryDomain();
MCS_Processor2.setDomain(MCS_Processor2Dom);	
variables.put("MCS_Processor2", MCS_Processor2); //including the variable in the map
//declaring variable Memory
Identifier Memory = factory.newIdentifier("Memory");
  			BinaryDomain MemoryDom= new BinaryDomain();
Memory.setDomain(MemoryDom);	
variables.put("Memory", Memory); //including the variable in the map
//declaring variable Memory_card
Identifier Memory_card = factory.newIdentifier("Memory_card");
 				RangeDomain Memory_cardDom= new RangeDomain(1, 4);
Memory_card.setDomain(Memory_cardDom);	
variables.put("Memory_card", Memory_card); //including the variable in the map
//declaring variable MCS_Processor1_Memory1
Identifier MCS_Processor1_Memory1 = factory.newIdentifier("MCS_Processor1_Memory1");
  			BinaryDomain MCS_Processor1_Memory1Dom= new BinaryDomain();
MCS_Processor1_Memory1.setDomain(MCS_Processor1_Memory1Dom);	
variables.put("MCS_Processor1_Memory1", MCS_Processor1_Memory1); //including the variable in the map
//declaring variable MCS_Processor1_Memory2
Identifier MCS_Processor1_Memory2 = factory.newIdentifier("MCS_Processor1_Memory2");
  			BinaryDomain MCS_Processor1_Memory2Dom= new BinaryDomain();
MCS_Processor1_Memory2.setDomain(MCS_Processor1_Memory2Dom);	
variables.put("MCS_Processor1_Memory2", MCS_Processor1_Memory2); //including the variable in the map
//declaring variable MCS_Processor2_Memory1
Identifier MCS_Processor2_Memory1 = factory.newIdentifier("MCS_Processor2_Memory1");
  			BinaryDomain MCS_Processor2_Memory1Dom= new BinaryDomain();
MCS_Processor2_Memory1.setDomain(MCS_Processor2_Memory1Dom);	
variables.put("MCS_Processor2_Memory1", MCS_Processor2_Memory1); //including the variable in the map
//declaring variable MCS_Processor2_Memory2
Identifier MCS_Processor2_Memory2 = factory.newIdentifier("MCS_Processor2_Memory2");
  			BinaryDomain MCS_Processor2_Memory2Dom= new BinaryDomain();
MCS_Processor2_Memory2.setDomain(MCS_Processor2_Memory2Dom);	
variables.put("MCS_Processor2_Memory2", MCS_Processor2_Memory2); //including the variable in the map
//declaring variable MCS
Identifier MCS = factory.newIdentifier("MCS");
  			BinaryDomain MCSDom= new BinaryDomain();
MCS.setDomain(MCSDom);	
variables.put("MCS", MCS); //including the variable in the map
	}
	public void transformConstraints() {
//
//declaring constraint c0


Identifier c0_left = variables.get("MCS");

NumericIdentifier c0_right = getValue("1");
IntBooleanExpression c0=
factory.equals(c0_left, c0_right);
constraints.put("c0", c0);
hlclProgram.add(c0);
//
//declaring constraint ac_0


Identifier ac_0_left = variables.get("MCS");



NumericIdentifier ac_0_right_left_left = getValue("1");


Identifier ac_0_right_left_right_left = variables.get("MCS_Processor1");

Identifier ac_0_right_left_right_right = variables.get("MCS_Processor2");
IntNumericExpression ac_0_right_left_right=factory.sum(ac_0_right_left_right_left, ac_0_right_left_right_right);	
IntBooleanExpression ac_0_right_left=
factory.lessOrEqualsThan(ac_0_right_left_left, ac_0_right_left_right);


NumericIdentifier ac_0_right_right_left = getValue("2");


Identifier ac_0_right_right_right_left = variables.get("MCS_Processor1");

Identifier ac_0_right_right_right_right = variables.get("MCS_Processor2");
IntNumericExpression ac_0_right_right_right=factory.sum(ac_0_right_right_right_left, ac_0_right_right_right_right);	
IntBooleanExpression ac_0_right_right=
factory.greaterOrEqualsThan(ac_0_right_right_left, ac_0_right_right_right);
IntBooleanExpression ac_0_right=factory.and(ac_0_right_left, ac_0_right_right);		
IntBooleanExpression ac_0=factory.doubleImplies(ac_0_left, ac_0_right);		
constraints.put("ac_0", ac_0);
hlclProgram.add(ac_0);
//
//declaring constraint ac_1


Identifier ac_1_left = variables.get("Processor_card");


Identifier ac_1_right_left = variables.get("MCS_Processor1");

Identifier ac_1_right_right = variables.get("MCS_Processor2");
IntNumericExpression ac_1_right=factory.sum(ac_1_right_left, ac_1_right_right);	
IntBooleanExpression ac_1=
factory.equals(ac_1_left, ac_1_right);
constraints.put("ac_1", ac_1);
hlclProgram.add(ac_1);
//
//declaring constraint ac_2


NumericIdentifier ac_2_left = getValue("1");


Identifier ac_2_right_left = variables.get("MCS_Processor1");

Identifier ac_2_right_right = variables.get("MCS_Processor2");
IntNumericExpression ac_2_right=factory.sum(ac_2_right_left, ac_2_right_right);	
IntBooleanExpression ac_2=
factory.lessOrEqualsThan(ac_2_left, ac_2_right);
constraints.put("ac_2", ac_2);
hlclProgram.add(ac_2);
//
//declaring constraint ac_3


NumericIdentifier ac_3_left = getValue("2");


Identifier ac_3_right_left = variables.get("MCS_Processor1");

Identifier ac_3_right_right = variables.get("MCS_Processor2");
IntNumericExpression ac_3_right=factory.sum(ac_3_right_left, ac_3_right_right);	
IntBooleanExpression ac_3=
factory.greaterOrEqualsThan(ac_3_left, ac_3_right);
constraints.put("ac_3", ac_3);
hlclProgram.add(ac_3);
//
//declaring constraint ac_4


Identifier ac_4_left = variables.get("Processor");


Identifier ac_4_right_left = variables.get("Processor_card");

NumericIdentifier ac_4_right_right = getValue("0");
IntBooleanExpression ac_4_right=
factory.greaterThan(ac_4_right_left, ac_4_right_right);
IntBooleanExpression ac_4=factory.doubleImplies(ac_4_left, ac_4_right);		
constraints.put("ac_4", ac_4);
hlclProgram.add(ac_4);
//
//declaring constraint c2


Identifier c2_left = variables.get("MCS");

Identifier c2_right = variables.get("Processor");
IntBooleanExpression c2=
factory.greaterOrEqualsThan(c2_left, c2_right);
constraints.put("c2", c2);
hlclProgram.add(c2);
//
//declaring constraint ac_5


Identifier ac_5_left = variables.get("MCS_Processor1");



NumericIdentifier ac_5_right_left_left = getValue("1");


Identifier ac_5_right_left_right_left = variables.get("MCS_Processor1_Memory1");

Identifier ac_5_right_left_right_right = variables.get("MCS_Processor1_Memory2");
IntNumericExpression ac_5_right_left_right=factory.sum(ac_5_right_left_right_left, ac_5_right_left_right_right);	
IntBooleanExpression ac_5_right_left=
factory.lessOrEqualsThan(ac_5_right_left_left, ac_5_right_left_right);


NumericIdentifier ac_5_right_right_left = getValue("2");


Identifier ac_5_right_right_right_left = variables.get("MCS_Processor1_Memory1");

Identifier ac_5_right_right_right_right = variables.get("MCS_Processor1_Memory2");
IntNumericExpression ac_5_right_right_right=factory.sum(ac_5_right_right_right_left, ac_5_right_right_right_right);	
IntBooleanExpression ac_5_right_right=
factory.greaterOrEqualsThan(ac_5_right_right_left, ac_5_right_right_right);
IntBooleanExpression ac_5_right=factory.and(ac_5_right_left, ac_5_right_right);		
IntBooleanExpression ac_5=factory.doubleImplies(ac_5_left, ac_5_right);		
constraints.put("ac_5", ac_5);
hlclProgram.add(ac_5);
//
//declaring constraint ac_6


Identifier ac_6_left = variables.get("MCS_Processor2");



NumericIdentifier ac_6_right_left_left = getValue("1");


Identifier ac_6_right_left_right_left = variables.get("MCS_Processor2_Memory1");

Identifier ac_6_right_left_right_right = variables.get("MCS_Processor2_Memory2");
IntNumericExpression ac_6_right_left_right=factory.sum(ac_6_right_left_right_left, ac_6_right_left_right_right);	
IntBooleanExpression ac_6_right_left=
factory.lessOrEqualsThan(ac_6_right_left_left, ac_6_right_left_right);


NumericIdentifier ac_6_right_right_left = getValue("2");


Identifier ac_6_right_right_right_left = variables.get("MCS_Processor2_Memory1");

Identifier ac_6_right_right_right_right = variables.get("MCS_Processor2_Memory2");
IntNumericExpression ac_6_right_right_right=factory.sum(ac_6_right_right_right_left, ac_6_right_right_right_right);	
IntBooleanExpression ac_6_right_right=
factory.greaterOrEqualsThan(ac_6_right_right_left, ac_6_right_right_right);
IntBooleanExpression ac_6_right=factory.and(ac_6_right_left, ac_6_right_right);		
IntBooleanExpression ac_6=factory.doubleImplies(ac_6_left, ac_6_right);		
constraints.put("ac_6", ac_6);
hlclProgram.add(ac_6);
//
//declaring constraint ac_7


Identifier ac_7_left = variables.get("Memory_card");




Identifier ac_7_right_left_left_left = variables.get("MCS_Processor1_Memory1");

Identifier ac_7_right_left_left_right = variables.get("MCS_Processor1_Memory2");
IntNumericExpression ac_7_right_left_left=factory.sum(ac_7_right_left_left_left, ac_7_right_left_left_right);	

Identifier ac_7_right_left_right = variables.get("MCS_Processor2_Memory1");
IntNumericExpression ac_7_right_left=factory.sum(ac_7_right_left_left, ac_7_right_left_right);	

Identifier ac_7_right_right = variables.get("MCS_Processor2_Memory2");
IntNumericExpression ac_7_right=factory.sum(ac_7_right_left, ac_7_right_right);	
IntBooleanExpression ac_7=
factory.equals(ac_7_left, ac_7_right);
constraints.put("ac_7", ac_7);
hlclProgram.add(ac_7);
//
//declaring constraint ac_8


NumericIdentifier ac_8_left = getValue("1");




Identifier ac_8_right_left_left_left = variables.get("MCS_Processor1_Memory1");

Identifier ac_8_right_left_left_right = variables.get("MCS_Processor1_Memory2");
IntNumericExpression ac_8_right_left_left=factory.sum(ac_8_right_left_left_left, ac_8_right_left_left_right);	

Identifier ac_8_right_left_right = variables.get("MCS_Processor2_Memory1");
IntNumericExpression ac_8_right_left=factory.sum(ac_8_right_left_left, ac_8_right_left_right);	

Identifier ac_8_right_right = variables.get("MCS_Processor2_Memory2");
IntNumericExpression ac_8_right=factory.sum(ac_8_right_left, ac_8_right_right);	
IntBooleanExpression ac_8=
factory.lessOrEqualsThan(ac_8_left, ac_8_right);
constraints.put("ac_8", ac_8);
hlclProgram.add(ac_8);
//
//declaring constraint ac_9


NumericIdentifier ac_9_left = getValue("4");




Identifier ac_9_right_left_left_left = variables.get("MCS_Processor1_Memory1");

Identifier ac_9_right_left_left_right = variables.get("MCS_Processor1_Memory2");
IntNumericExpression ac_9_right_left_left=factory.sum(ac_9_right_left_left_left, ac_9_right_left_left_right);	

Identifier ac_9_right_left_right = variables.get("MCS_Processor2_Memory1");
IntNumericExpression ac_9_right_left=factory.sum(ac_9_right_left_left, ac_9_right_left_right);	

Identifier ac_9_right_right = variables.get("MCS_Processor2_Memory2");
IntNumericExpression ac_9_right=factory.sum(ac_9_right_left, ac_9_right_right);	
IntBooleanExpression ac_9=
factory.greaterOrEqualsThan(ac_9_left, ac_9_right);
constraints.put("ac_9", ac_9);
hlclProgram.add(ac_9);
//
//declaring constraint ac_10


Identifier ac_10_left = variables.get("Memory");


Identifier ac_10_right_left = variables.get("Memory_card");

NumericIdentifier ac_10_right_right = getValue("0");
IntBooleanExpression ac_10_right=
factory.greaterThan(ac_10_right_left, ac_10_right_right);
IntBooleanExpression ac_10=factory.doubleImplies(ac_10_left, ac_10_right);		
constraints.put("ac_10", ac_10);
hlclProgram.add(ac_10);
//
//declaring constraint c4


Identifier c4_left = variables.get("Processor");

Identifier c4_right = variables.get("Memory");
IntBooleanExpression c4=
factory.greaterOrEqualsThan(c4_left, c4_right);
constraints.put("c4", c4);
hlclProgram.add(c4);
	}
	public boolean evaluateSatisfiability(){
		// the output
		boolean evaluation= false;
		// //to transform the hllcl program into a prolog  file, 
		// //these lines are commented because they are useful for debugging 
		Hlcl2SWIProlog swiPrologTransformer = new Hlcl2SWIProlog(); 
		prologProgram = swiPrologTransformer.transform(hlclProgram);
				
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