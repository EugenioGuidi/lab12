package it.unibo.es1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LogicsImpl implements Logics {

	private final List<Integer> listInteger;

	public LogicsImpl(final int size) {
		this.listInteger = IntStream.range(0, size)
								.mapToObj(i -> 0)
								.collect(Collectors.toList());
	}

	@Override
	public int size() {
		return this.listInteger.size();
	}

	@Override
	public List<Integer> values() {
		return this.listInteger;
	}

	@Override
	public List<Boolean> enablings() {
		return this.listInteger
					.stream()
					.map(i -> i.equals(this.listInteger.size()) ? false : true)
					.toList();
	}

	@Override
	public int hit(int elem) {
		return this.listInteger
					.set(elem, this.listInteger.get(elem) + 1) + 1;
	}

	@Override
	public String result() {
		return listInteger
					.stream()
					.map(String::valueOf)
					.collect(Collectors.joining("|", "<<", ">>"));
	}

	@Override
	public boolean toQuit() {

		return this.listInteger
					.stream()
					.allMatch(i -> i.equals(this.listInteger.get(0)))
					;
	}
}
