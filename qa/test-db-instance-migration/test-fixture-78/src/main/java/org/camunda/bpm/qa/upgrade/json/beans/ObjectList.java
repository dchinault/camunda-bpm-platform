package org.camunda.bpm.qa.upgrade.json.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Svetlana Dorokhova.
 */
public class ObjectList implements List<Object> {

  protected List<Object> innerList = new ArrayList<Object>();

  @Override
  public int size() {
    return innerList.size();
  }

  @Override
  public boolean isEmpty() {
    return innerList.isEmpty();
  }

  @Override
  public boolean contains(Object o) {
    return innerList.contains(o);
  }

  @Override
  public Iterator<Object> iterator() {
    return innerList.iterator();
  }

  @Override
  public Object[] toArray() {
    return innerList.toArray();
  }

  @Override
  public <Object> Object[] toArray(Object[] a) {
    return innerList.toArray(a);
  }

  @Override
  public boolean add(Object customer) {
    return innerList.add(customer);
  }

  @Override
  public boolean remove(Object o) {
    return innerList.remove(o);
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    return innerList.containsAll(c);
  }

  @Override
  public boolean addAll(Collection<? extends Object> c) {
    return innerList.addAll(c);
  }

  @Override
  public boolean addAll(int index, Collection<? extends Object> c) {
    return innerList.addAll(index, c);
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    return innerList.removeAll(c);
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    return innerList.retainAll(c);
  }

  @Override
  public void clear() {
    innerList.clear();
  }

  @Override
  public boolean equals(Object o) {
    return innerList.equals(o);
  }

  @Override
  public int hashCode() {
    return innerList.hashCode();
  }

  @Override
  public Object get(int index) {
    return innerList.get(index);
  }

  @Override
  public Object set(int index, Object element) {
    return innerList.set(index, element);
  }

  @Override
  public void add(int index, Object element) {
    innerList.add(index, element);
  }

  @Override
  public Object remove(int index) {
    return innerList.remove(index);
  }

  @Override
  public int indexOf(Object o) {
    return innerList.indexOf(o);
  }

  @Override
  public int lastIndexOf(Object o) {
    return innerList.lastIndexOf(o);
  }

  @Override
  public ListIterator<Object> listIterator() {
    return innerList.listIterator();
  }

  @Override
  public ListIterator<Object> listIterator(int index) {
    return innerList.listIterator(index);
  }

  @Override
  public List<Object> subList(int fromIndex, int toIndex) {
    return innerList.subList(fromIndex, toIndex);
  }
}
