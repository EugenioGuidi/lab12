package it.unibo.es1;

import java.util.ArrayList;
import java.util.List;

public class LogicsImpl implements Logics {

	private int size;
	private final List<Integer> listInteger;
	private final List<Boolean> listBoolean;

	public LogicsImpl(final int size) {
		this.size = size;
		this.listInteger = new ArrayList<>();
		this.listBoolean = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			listBoolean.add(true);
			listInteger.add(0);
		}
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public List<Integer> values() {
		return this.listInteger;
	}

	@Override
	public List<Boolean> enablings() {
		return this.listBoolean;
	}

	@Override
	public int hit(int elem) {
		if (this.listBoolean.get(elem)) {
			this.listInteger.set(elem, this.listInteger.get(elem) + 1);
		}
		if (this.listInteger.get(elem) == this.size) {
			this.listBoolean.set(elem, false);
		}
		return this.listInteger.get(elem);
	}

	@Override
	public String result() {
		String string = "<<";
		for(int i = 0; i < size; i++) {
			string = string + listInteger.get(i);
			if (i != size - 1) {
				string = string + "|";
			}
		}
		string = string + ">>";
		return string;
	}

	@Override
	public boolean toQuit() {
		boolean flag = true;
		for(Integer integer : this.listInteger) {
			if(!listInteger.get(0).equals(integer)) {
				flag = false;
			}
		}
		return flag;
	}
}
