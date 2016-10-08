package br.com.teste.util.thymeleaf;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import br.com.teste.util.thymeleaf.processor.ClassForErrorAttributeTagProcessor;
import br.com.teste.util.thymeleaf.processor.MenuAttributeTagProcessor;
import br.com.teste.util.thymeleaf.processor.MessageElementTagProcessor;

public class JFDialect extends AbstractProcessorDialect {
	public JFDialect() {
		super("JF Consultores", "jf", StandardDialect.PROCESSOR_PRECEDENCE);
	}
	
	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		final Set<IProcessor> processadores = new HashSet<>();
		processadores.add(new ClassForErrorAttributeTagProcessor(dialectPrefix));
		processadores.add(new MessageElementTagProcessor(dialectPrefix));
		processadores.add(new MenuAttributeTagProcessor(dialectPrefix));
		return processadores;
	}
}
