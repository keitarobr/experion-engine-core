package br.ufsc.ppgcc.experion.view.expertise.builder.engine;

import br.ufsc.ppgcc.experion.model.evidence.LogicalEvidence;
import br.ufsc.ppgcc.experion.view.expertise.Expertise;

import java.util.Set;

/**
 * The interface a class that wants to act as an ExpertiseBuilderEngine must implement
 *
 * @author Rodrigo Gonçalves
 * @version 2019-03-05 - First version
 *
 */
public interface ExpertiseBuilderEngine {

    /** Given a set of logical evidences, must return one or more identified expertise */
    Set<Expertise> buildExpertise(Set<LogicalEvidence> evidences);
}
