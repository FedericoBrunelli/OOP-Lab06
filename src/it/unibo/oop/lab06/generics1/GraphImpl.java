package it.unibo.oop.lab06.generics1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//GRAFO NON ORIENTATO!!!
public class GraphImpl<N> implements Graph<N> {

	private Map<N, Set<N>> archi = new HashMap<>();
	
	public GraphImpl() {

	}
	@Override
	public void addNode(N node) {
		archi.putIfAbsent(node, new HashSet<>());
		
	}

	@Override
	public void addEdge(N source, N target) {
		if (archi.containsKey(source) && archi.containsKey(target)) {
			//AGGIUNGO ARCO TRA 'source' E 'target'
			archi.get(source).add(target);
			archi.get(target).add(source);
		}
				
	}

	@Override
	public Set<N> nodeSet() {
		return new HashSet<>(archi.keySet());
	}

	@Override
	public Set<N> linkedNodes(N node) {
		return new HashSet<>(archi.get(node));
	}

	@Override
	public List<N> getPath(N source, N target) {
		List<N> pathList = new ArrayList<>();
		pathList.add(source);
		for (N node : this.linkedNodes(source)) {
			if (node == target) {
				pathList.add(node);
				break;
			} else {
				if (this.linkedNodes(target).contains(node)) {
					pathList.add(node);
					pathList.add(target);
					break;
				}
			}
			for (N elem : this.linkedNodes(node)) {
				this.getPath(node, elem);
			}
		}
		return pathList;
	}

	
}
