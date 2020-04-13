package br.com.erudio.converters;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozerConverter {
	
	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
	public static <S, D> D parseObject(S source, Class<D> destinationClass) {
		return mapper.map(source, destinationClass);
	}
	
	public static <S, D> List<D> parseListObjects(List<S> source, Class<D> destinationClass) {
		List<D> destinationObjects = new ArrayList<D>();
		
		for (Object objectSource : source) {
			destinationObjects.add(mapper.map(objectSource, destinationClass));
		}
		
		return destinationObjects;
	}
}
