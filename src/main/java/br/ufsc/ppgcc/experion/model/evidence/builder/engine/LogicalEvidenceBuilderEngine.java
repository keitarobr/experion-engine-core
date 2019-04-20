package br.ufsc.ppgcc.experion.model.evidence.builder.engine;

import br.ufsc.ppgcc.experion.extractor.evidence.PhysicalEvidence;
import br.ufsc.ppgcc.experion.model.evidence.LogicalEvidence;

import java.util.Set;

/**
 * Interface that must be implemented by a class that wants to act as the engine for a LogicalEvidenceBuilder
 *
 * @author Rodrigo Gonçalves
 * @version 2019-03-05 - First version
 *
 */
public interface LogicalEvidenceBuilderEngine {

    /** Must return a set of logical evidences given a set of physical evidences */
    Set<LogicalEvidence> getLogicalEvidences(Set<PhysicalEvidence> evidenceSet);
}
