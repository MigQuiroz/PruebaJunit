
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.*;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class GeneralAssertions {

	@Test
	public void _CollectionContains() {
		String [] testArray = {"a", "b", "c", "d", "e"};
		Collection<String> tested = Arrays.asList(testArray);
		assertThat("Is the item contained", tested, hasItem("c"));
	}
	
	@Test
	public void _CheckCollection() {
		String [] testArray = {"a", "b", "c", "d", "e"};
		Collection<String> tested = Arrays.asList(testArray);
		assertThat("Any item meets the criteria", tested, hasItems("b","e"));
	}

	@Test
	public void _CollectionSearch() {
		String [] testArray = {"dog", "cat", "tiget", "mouse", "unicorn"};
		Collection<String> tested = Arrays.asList(testArray);
		assertThat("Any item meets the criteria", tested,hasItem(startsWith("uni")));
	}
	
	@Test
	public void _CollectionFilter() {
		String [] testArray = {"dog", "cat", "tiget", "mouse", "unicorn"};
		Collection<String> tested = Arrays.asList(testArray);
		assertThat("All item meets the criteria", tested,everyItem(not(endsWith("uni"))));
	}
	//Assume
	@Test
	public void assumeBoolean() {
		assumeFalse("This should be false", false);
		assumeTrue("This should be true", true);
		System.out.println("Boolean ok");
		}
	
	@Test
	public void noExeption() {
		try {
			Integer.parseInt("1");
		}
		catch (NumberFormatException e) {
			assumeNoException("Should not fail",e);
			System.out.println("No exception happend");
		}
	}
}
