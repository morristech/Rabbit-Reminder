package com.pyxistech.android.rabbitreminder.models;

import java.util.Vector;

import android.os.Parcel;
import android.os.Parcelable;

public class TaskList implements Parcelable {
	
	public TaskList() {
	}
	
	public TaskList(Parcel in) {
		int size = in.readInt();
		for (int i = 0; i < size; i++) {
			TaskItem item = in.readParcelable(getClass().getClassLoader());
			items.add(item);
		}
	}
	
	public boolean equals(TaskList list) {
		return items.equals(list.items);
	}
	
	public void addItem(TaskItem item) {
		items.add(item);
	}
	
	public void deleteItem(int index) {
		items.remove(index);
	}
	
	public TaskItem getItemAt(int index) {
		return items.elementAt(index);
	}
	
	public TaskItem[] toArray() {
		return (TaskItem[]) items.toArray(new TaskItem[items.size()]);
	}

	public int describeContents() {
		return 0;
	}
	
	public int size(){
		return items.size();
	}

	public void writeToParcel(Parcel out, int flag) {
		out.writeInt(items.size());
		for (TaskItem item : items) {
			out.writeParcelable(item, 0);
		}
	}

	public void updateItem(int index, String newText) {
		items.elementAt(index).setText(newText);
	}
	
	public void clear() {
		items.clear();
	}
	
	private Vector<TaskItem> items = new Vector<TaskItem>();
}