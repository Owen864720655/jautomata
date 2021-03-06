package net.jhoogland.jautomata.operations;

import java.util.Comparator;

import net.jhoogland.jautomata.Automaton;
import net.jhoogland.jautomata.semirings.Semiring;

/**
 * Abstract class for semiring conversion operations.
 * 
 * @author Jasper Hoogland
 *
 * @see
 * Semiring
 *
 * @param <L>
 * label type
 * 
 * @param <K1>
 * operand weight type
 * (Boolean for regular automata and Double for weighted automata)
 * 
 * @param <K2>
 * operation weight type
 * (Boolean for regular automata and Double for weighted automata)
 */
public abstract class SemiringConversion<L, K1, K2> extends UnaryOperation<L, L, K1, K2>
{
	public SemiringConversion(Automaton<L, K1> operand, Semiring<K2> semiring) 
	{
		super(operand, semiring);		
	}

	public K2 transitionWeight(Object transition) 
	{
		return convertWeight(operand.transitionWeight(transition));
	}
	
	public K2 initialWeight(Object state) 
	{
		return convertWeight(operand.initialWeight(state));
	}
	
	public K2 finalWeight(Object state) 
	{
		return convertWeight(operand.finalWeight(state));
	}
	
	public abstract K2 convertWeight(K1 weight);

	public L label(Object transition) 
	{		
		return operand.label(transition);
	}

	@Override
	public Comparator<Object> topologicalOrder() 
	{		
		return operand.topologicalOrder();
	}
}
