package br.ufsc.ppgcc.experion.extractor.input.engine;

import br.ufsc.ppgcc.experion.extractor.evidence.PhysicalEvidence;
import br.ufsc.ppgcc.experion.extractor.input.EvidenceSourceInput;
import br.ufsc.ppgcc.experion.extractor.source.EvidenceSource;
import br.ufsc.ppgcc.experion.model.expert.Expert;

import java.util.Set;

/**
 *
 * Interface required to be implemented by a class that can act as the engine behind a EvidenceSourceInput.
 *
 * @author Rodrigo Gonçalves
 * @version 2019-03-05 - First version
 *
 */
public interface EvidenceSourceInputEngine {

    /** Which language (language code ISO) the engine must collect evidences from */
    void setLanguage(String language);

    /** Which language (language code ISO) the engine must collect evidences from */
    String getLanguage();

    /** Must return the experts present in this source */
    Set<Expert> getExpertEntities();

    /** Given an expert, must return the evidences contained in this source for him/her */
    Set<PhysicalEvidence> getNewEvidences(Expert expert, EvidenceSourceInput input);

    /** Must return all experts in the source which name contains the given string (case insentitive)*/
    Set<Expert> findExpertByName(String name);

    /** Defines over which datasource this engine works */
    void setEvidenceSource(EvidenceSource evidenceSource);

    /** Returns over which datasource this engine works */
    EvidenceSource getEvidenceSource();
}
