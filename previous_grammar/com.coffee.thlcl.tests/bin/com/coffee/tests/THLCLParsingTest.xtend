/*
 * generated by Xtext 2.12.0
 */
package com.coffee.tests


import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import com.coffee.tHLCL.THLCLPackage
import com.coffee.validation.THLCLValidator
import com.coffee.tHLCL.Model
import com.coffee.tHLCL.Relational
import com.coffee.tHLCL.Constraint
import com.coffee.tHLCL.Plus
import com.coffee.tHLCL.Minus
import com.coffee.tHLCL.MulOrDiv
import com.coffee.tHLCL.Comparison
import com.coffee.tHLCL.Equality
import com.coffee.tHLCL.And
import com.coffee.tHLCL.Or
import com.coffee.tHLCL.Negation
import com.coffee.tHLCL.Unary
import com.coffee.tHLCL.IntConstant
import com.coffee.tHLCL.BoolConstant
import com.coffee.tHLCL.VariableRef

@RunWith(XtextRunner)
@InjectWith(THLCLInjectorProvider)

/**
 * Class to test the constraint programming grammar and its parsing
 * @author Angela Villota
 * @version THLCL V3
 * August 2018
 */
class THLCLParsingTest {
	@Inject
	ParseHelper<Model> parseHelper
	@Inject extension ParseHelper
	@Inject extension ValidationTestHelper
	
/*********************************************************************************************************
 * Methods to test the parser
 * 
 */
 	@Test
	def void emptyModel(){
		val model= '''model empty
		variables:
		constraints: '''
		val vacio = parseHelper.parse(model)
		Assert.assertNotNull(vacio)
		Assert.assertTrue(vacio.eResource.errors.isEmpty)
	}
	
		@Test
	def void integerVarsEnum(){
		val model= 
		'''
		model m1
		variables:
		integer A domain: [10, 20, 30, 40]
		constraints: 
		'''
		val vacio = parseHelper.parse(model)
		Assert.assertNotNull(vacio)
		Assert.assertTrue(vacio.eResource.errors.isEmpty)
	}
	@Test
	def void integerVarsInterval(){
		val model= 
		'''
		model m1
		variables:
		integer A domain: 1..20
		constraints: 
		'''
		val vacio = parseHelper.parse(model)
		Assert.assertNotNull(vacio)
		Assert.assertTrue(vacio.eResource.errors.isEmpty)
	}
	@Test
	def void boolVarDeclaration(){
		val model= 
		'''
		model m1
		variables:
		boolean A 
		constraints: 
		'''
		val vacio = parseHelper.parse(model)
		Assert.assertNotNull(vacio)
		Assert.assertTrue(vacio.eResource.errors.isEmpty)
	}
	
	/**
	 * Testing numeric expressions 
	 */
	@Test
	def void relationalOperatorsVars(){
		val model= 
		'''
		model m1
		variables:
		integer A domain: 1..10
		integer B domain: 1..20
		integer C domain: 40..50
		constraints: 
		c1: A=B
		c2: A!=C
		c3: B > C
		c4: B >= C
		c5: A < C
		C6: F <= C
		'''
		val vacio = parseHelper.parse(model)
		Assert.assertNotNull(vacio)
		printErrors(vacio)
		Assert.assertTrue(vacio.eResource.errors.isEmpty)
	}
	@Test
	def void referencingVars(){
		val model= 
		'''
		model m1
		variables:
		integer A domain: 1..10
		constraints: 
		c1: A=1
		'''
		val m1 = parseHelper.parse(model)
		Assert.assertNotNull(m1)
		Assert.assertTrue(m1.eResource.errors.isEmpty)
		printErrors(m1)
		Assert.assertSame((((m1.constraints.get(0) as Constraint).exp as Equality).left as VariableRef).variable, m1.variables.get(0)) 
		

	}	
	@Test
	def void relationalOperatorsNums(){
		val model= 
		'''
		model m1
		variables:
		integer A domain: 1..10
		integer B domain: 1..20
		integer C domain: 40..50
		constraints: 
		c1: 1=1
		c2: 2!=1
		c3: 10 > 2
		c4: 10 >= 2
		c5: 1 < 5
		C6: 1 <= 5
		'''
		val vacio = parseHelper.parse(model)
		Assert.assertNotNull(vacio)
		printErrors(vacio)
		Assert.assertTrue(vacio.eResource.errors.isEmpty)
	}
	
	@Test
	def void arithmeticOperatorsUnary(){
		val model= 
		'''
		model m1
		variables:
		integer A domain: 1..10
		integer B domain: 1..20
		integer C domain: 40..50
		constraints: 
		c1: abs(1) =1
		c2: abs(A) = 1
		c3: sqrt(4) = 2
		c4: sqrt(B) = 2
		c5: abs(1) = abs(A)
		c6: sqrt(4) = sqrt(B)
		'''
		val vacio = parseHelper.parse(model)
		Assert.assertNotNull(vacio)
		printErrors(vacio)
		Assert.assertTrue(vacio.eResource.errors.isEmpty)
	}
	
	@Test
	def void functionOperators(){
		val model= 
		'''
		model m1
		variables:
		integer A domain: 1..10
		integer B domain: 1..20
		integer C domain: 40..50
		constraints: 
		c1: max(A, B)
		c2: min(A, 10)
		c3: pow(C,2)
		c4: dist(max(A, C), min(B,C) )
		'''
		val vacio = parseHelper.parse(model)
		Assert.assertNotNull(vacio)
		printErrors(vacio)
		Assert.assertTrue(vacio.eResource.errors.isEmpty)
	}
	
	@Test
	def void LogicOperators(){
		val model= 
		'''
		model m1
		variables:
		boolean A 
		boolean B 
		boolean C 
		constraints: 
		c1: true AND true
		c2: ~A
		c3: A=>B
		c4: A<=>C
		c5: A AND B AND C
		C6: A AND B AND C OR A => C
		'''
		val vacio = parseHelper.parse(model)
		Assert.assertNotNull(vacio)
		printErrors(vacio)
		Assert.assertTrue(vacio.eResource.errors.isEmpty)
	}

	/**
	 * Method to test that the parsing is left-rigth
	 */
	@Test 
	def void testPlus() {
		'''
		model m1
		variables:
		integer A domain: 1..10
		constraints: 
		c1: 10 + 5 + 1 + 2
		'''.assertRepr("(((10 + 5) + 1) + 2)") 
	}
	/**
	 * Method for testing the  arithmetic expressions are correctly parenthesized
	 */
	@Test 
	def void testPlusWithParenthesis() {
		'''model m1
			variables:
			integer A domain: 1..10
			constraints: 
			c1: ( 10 + 5 ) + ( 1 + 2 )'''.assertRepr("((10 + 5) + (1 + 2))")
	}
	
	/**
	 * Method to test the precedence of the arithmetic operators
	 */
	@Test 
	def void testPlusMulPrecedence() {
		'''
		model m1
		variables:
		integer A domain: 1..10
		constraints: 
			c1: 10 + 5 * 2 - 5 / 1'''.assertRepr("((10 + (5 * 2)) - (5 / 1))") }
	
	@Test 
	def void testPrecedences() { 
		'''
		model m1
		variables:
		integer A domain: 1..10
		constraints: 
		c1: ~true OR false AND 1>(1/3+5*2)'''
	. assertRepr("((~true) OR (false AND (1 > ((1 / 3) + (5 * 2)))))") 
	}
/*****************************************************************************************************
 * Testing errors and validations
 */
	@Test
	def void integerNoDomainError(){
		val model= 
		'''
		model m1
		variables:
		integer A 
		constraints: 
		'''.parse
		model.assertError(THLCLPackage::eINSTANCE.variable, 
			null,
			 "A domain declaration is required for variable 'A'"
		)
	}
	
	@Test
	def void stringNoDomainError(){
		val model= 
		'''
		model m1
		variables:
		symbolic A 
		constraints: 
		'''.parse
		model.assertError(THLCLPackage::eINSTANCE.variable, 
			null,
			 "A domain declaration is required for variable 'A'"
		)
	}
	
	//FIXME this test does not work 
	def void nonDeclaredVariableError(){
		val model= 
		'''
		model m1
		variables:
		boolean A
		boolean B
		constraints:
		c1: A + B
		c2: A + C 
		'''.parse
		model.assertError(THLCLPackage::eINSTANCE.variable, 
			THLCLValidator::FORWARD_REFERENCE,
			 "Variables should be declared before being used: 'C'"
		)
	}

/**********************************************************************************************************
* Auxiliar methods for testing
*/
	 
	 /**
	  * Method to obtain the textual representation of a expression
	  */
	def stringRepr(Relational e) { 
		switch (e) { 
			Plus:
				'''(«e.left.stringRepr» + «e.right.stringRepr»)''' 
			Minus:
				'''(«e.left.stringRepr» - «e.right.stringRepr»)''' 
			MulOrDiv:
				'''(«e.left.stringRepr» «e.op» «e.right.stringRepr»)'''
			Comparison:
				'''(«e.left.stringRepr» «e.op» «e.right.stringRepr»)'''
			Equality:
				'''(«e.left.stringRepr» «e.op» «e.right.stringRepr»)'''
			And:
				'''(«e.left.stringRepr» AND «e.right.stringRepr»)'''
			Or:
				'''(«e.left.stringRepr» OR «e.right.stringRepr»)'''
			Negation:
				'''(~«e.expression.stringRepr»)'''
			Unary:
				'''(«e.op»«e.expression.stringRepr»)'''
			IntConstant: 
				'''«e.value»''' 
			BoolConstant: 
				'''«e.value»''' 
			VariableRef: 
				'''«e.variable.name»''' 
		}.toString
	}
	
	 /**
	  * Method to compare the representation of an expression and a string with the expecting values
	  * USeful to test the correct parenthesizing and asociation of the arithmetic expressions
	  */
	def assertRepr(CharSequence input, CharSequence expected) 
	{ val model= parseHelper.parse(input)
		Assert.assertNotNull(model);
		Assert.assertTrue(model.eResource.errors.isEmpty);
		printErrors(model)
		Assert.assertEquals(((model.constraints.get(0) as Constraint).exp as Relational).stringRepr(), expected);
		
	}
	
	/**to print the parsing errors */
	def void printErrors(Model model){
		if (!model.eResource.errors.isEmpty){
			for (element : model.eResource.errors) {
				println( element.message)
			}
		}
		
	}
}
