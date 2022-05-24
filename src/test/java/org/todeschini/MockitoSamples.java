package org.todeschini;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.List;

import static  org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

// para usar veja o pom
@ExtendWith(MockitoExtension.class) // substitui o RunWith do junit4
public class MockitoSamples {

    // com anotation
    @Mock
    List<String> myList;

    // implicito no codigo
    @Test
    public void testMockListAnnotation() {
        // given

        //when
        when(myList.size()).thenReturn(2);

        // then
        assertThat(myList.size()).isEqualTo(2);

        //com mockito verifico se o metodo size foi chamado
        verify(myList).size();

        //com mockito verifico quantas vezes o metodo size foi chamado
        verify(myList, times(1)).size();
    }


    // implicito no codigo
    @Test
    public void testMockList() {
        // given
        List<String> lista = mock(ArrayList.class);

        //when
        when(lista.size()).thenReturn(2);

        // then
        assertThat(lista.size()).isEqualTo(2); // uma chamada ao metodo

        //com mockito verifico se o metodo size foi chamado
        verify(lista).size();

        //com mockito verifico quantas vezes o metodo size foi chamado
        verify(lista, times(1)).size();
    }

    // implicito no codigo
    @Test
    public void testMockListTimesSamples() {
        // given
        List<String> l1 = mock(ArrayList.class);
        List<String> l2 = mock(ArrayList.class);

        //when
        when(l1.size()).thenReturn(1).thenReturn(1);
        when(l2.size()).thenReturn(1);

        // duas chamada ao metodo size da lista l1

        // then
        var i = l1.size();
        i += l1.size();
        i += l2.size();

        //com mockito verifico se o metodo size foi chamado
        assertThat(i).isEqualTo(3);

        //com mockito verifico quantas vezes o metodo size foi chamado
        verify(l1, times(2)).size(); // teste duas vez chamando size de l1
        verify(l2, times(1)).size();
    }

    // implicito no codigo
    @Test
    public void testMockListTimesSamplesNever() {
        // given
        List<String> l1 = mock(ArrayList.class);

        //when
//        when(l1.size()).thenReturn(1);

        // duas chamada ao metodo size da lista l1

        //com mockito verifico quantas vezes o metodo size foi chamado
        verify(l1, never()).size(); // teste que nunca foi chamado

    }

    // com annotation
    @Test
    public void testMockListInOrder() {
        // given
        myList.size();
        myList.add("");

        InOrder order = inOrder(myList);
        order.verify(myList).size();
        order.verify(myList).add("");
    }
}
