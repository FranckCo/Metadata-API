package fr.insee.rmes.modeles.operations;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import fr.insee.rmes.modeles.StringWithLang;
import fr.insee.rmes.utils.Lang;

public class Indicateur {

    private String id = null;
    private String uri = null;
    private List<StringWithLang> label = new ArrayList<StringWithLang>();
    @JsonInclude(Include.NON_NULL)
    private List<StringWithLang> altLabel;

    @JsonInclude(Include.NON_NULL)
    private List<StringWithLang> abstractIndic = null;
    @JsonInclude(Include.NON_NULL)
    private List<StringWithLang> historyNote;

    @JsonInclude(Include.NON_NULL)
    private SimpleObject creator;
    @JsonInclude(Include.NON_NULL)
    private List<SimpleObject> contributors;
    @JsonInclude(Include.NON_NULL)
    private List<Indicateur> replaces;
    @JsonInclude(Include.NON_NULL)
    private List<Indicateur> isReplacedBy;
    @JsonInclude(Include.NON_NULL)
    private List<SimpleObject> seeAlso;
    @JsonInclude(Include.NON_NULL)
    private List<Serie> wasGeneratedBy;

    @JsonInclude(Include.NON_NULL)
    private SimpleObject accrualPeriodicity = null;

    @JsonInclude(Include.NON_NULL)
    private String simsId = null;

    public Indicateur(String uri, String id, String labelLg1, String labelLg2, String simsId) {
        super();
        this.id = id;
        label.add(new StringWithLang(labelLg1, Lang.FR));
        if (labelLg2 != "") {
            label.add(new StringWithLang(labelLg2, Lang.EN));
        }
        if (simsId != "") this.simsId = simsId;
        this.uri = uri;
    }

    public Indicateur() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JacksonXmlProperty(localName = "label")
    @JacksonXmlElementWrapper(useWrapping = false)
    public List<StringWithLang> getLabel() {
        return label;
    }

    public void setLabel(List<StringWithLang> label) {
        this.label = label;
    }

    public String getSimsId() {
        return simsId;
    }

    public void setSimsId(String simsId) {
        if (simsId != "") this.simsId = simsId;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setLabelFr(String labelFr) {
        if (StringUtils.isNotEmpty(labelFr)) {
            label.add(new StringWithLang(labelFr, Lang.FR));
        }
    }

    public void setLabelEn(String labelEn) {
        if (StringUtils.isNotEmpty(labelEn)) {
            label.add(new StringWithLang(labelEn, Lang.EN));
        }
    }

    @JacksonXmlProperty(localName = "altLabel")
    @JacksonXmlElementWrapper(useWrapping = false)
    public List<StringWithLang> getAltLabel() {
        return altLabel;
    }

    public void setAltLabel(List<StringWithLang> altLabel) {
        this.altLabel = altLabel;
    }

    public void setAltLabel(String altLabelLg1, String altLabelLg2) {
        if (altLabelLg1 != "") {
            if (altLabel == null) altLabel = new ArrayList<StringWithLang>();
            label.add(new StringWithLang(altLabelLg1, Lang.FR));
        }
        if (altLabelLg2 != "") {
            if (altLabel == null) altLabel = new ArrayList<StringWithLang>();
            label.add(new StringWithLang(altLabelLg2, Lang.EN));
        }
    }

    public void addSeeAlso(SimpleObject sa) {
        if (seeAlso == null) {
            setSeeAlso(new ArrayList<SimpleObject>());
        }
        this.seeAlso.add(sa);
    }

    public void addReplaces(Indicateur rep) {
        if (replaces == null) {
            setReplaces(new ArrayList<Indicateur>());
        }
        this.replaces.add(rep);
    }

    public void addIsReplacedBy(Indicateur irb) {
        if (isReplacedBy == null) {
            setIsReplacedBy(new ArrayList<Indicateur>());
        }
        this.isReplacedBy.add(irb);
    }

    @JsonProperty("remplace")
    @JacksonXmlProperty(isAttribute = true, localName = "remplace")
    @JacksonXmlElementWrapper(useWrapping = false)
    public List<Indicateur> getReplaces() {
        return replaces;
    }

    public void setReplaces(List<Indicateur> replaces) {
        this.replaces = replaces;
    }

    @JsonProperty("estRemplacePar")
    @JacksonXmlProperty(isAttribute = true, localName = "estRemplacePar")
    @JacksonXmlElementWrapper(useWrapping = false)
    public List<Indicateur> getIsReplacedBy() {
        return isReplacedBy;
    }

    public void setIsReplacedBy(List<Indicateur> isReplacedBy) {
        this.isReplacedBy = isReplacedBy;
    }

    @JsonProperty("voirAussi")
    @JacksonXmlProperty(isAttribute = true, localName = "voirAussi")
    @JacksonXmlElementWrapper(useWrapping = false)
    public List<SimpleObject> getSeeAlso() {
        return seeAlso;
    }

    public void setSeeAlso(List<SimpleObject> seeAlso) {
        this.seeAlso = seeAlso;
    }

    @JsonProperty("produitDe")
    @JacksonXmlProperty(isAttribute = true, localName = "produitDe")
    @JacksonXmlElementWrapper(useWrapping = false)
    public List<Serie> getWasGeneratedBy() {
        return wasGeneratedBy;
    }

    public void setWasGeneratedBy(List<Serie> wasGeneratedBy) {
        this.wasGeneratedBy = wasGeneratedBy;
    }

    @JsonProperty("periodicite")
    @JacksonXmlProperty(isAttribute = true, localName = "periodicite")
    @JacksonXmlElementWrapper(useWrapping = false)
    public SimpleObject getAccrualPeriodicity() {
        return accrualPeriodicity;
    }

    public void setAccrualPeriodicity(SimpleObject accrualPeriodicity) {
        this.accrualPeriodicity = accrualPeriodicity;
    }

    @JsonProperty("resume")
    @JacksonXmlProperty(localName = "resume")
    @JacksonXmlElementWrapper(useWrapping = false)
    public List<StringWithLang> getAbstractIndic() {
        return abstractIndic;
    }

    public void setAbstractLg1(String abstractLg1) {
        if (StringUtils.isNotEmpty(abstractLg1)) {
            if (abstractIndic == null) abstractIndic = new ArrayList<>();
            abstractIndic.add(new StringWithLang(abstractLg1, Lang.FR));
        }
    }

    public void setAbstractLg2(String abstractLg2) {
        if (StringUtils.isNotEmpty(abstractLg2)) {
            if (abstractIndic == null) abstractIndic = new ArrayList<>();
            abstractIndic.add(new StringWithLang(abstractLg2, Lang.EN));
        }
    }

    @JsonProperty("noteHistorique")
    @JacksonXmlProperty(localName = "noteHistorique")
    @JacksonXmlElementWrapper(useWrapping = false)
    public List<StringWithLang> getHistoryNote() {
        return historyNote;
    }

    public void setHistoryNoteLg1(String str) {
        if (StringUtils.isNotEmpty(str)) {
            if (historyNote == null) historyNote = new ArrayList<>();
            historyNote.add(new StringWithLang(str, Lang.FR));
        }
    }

    public void setHistoryNoteLg2(String str) {
        if (StringUtils.isNotEmpty(str)) {
            if (historyNote == null) historyNote = new ArrayList<>();
            historyNote.add(new StringWithLang(str, Lang.EN));
        }
    }

    @JsonProperty("organismeResponsable")
    @JacksonXmlProperty(isAttribute = true, localName = "organismeResponsable")
    @JacksonXmlElementWrapper(useWrapping = false)
    public SimpleObject getCreator() {
        return creator;
    }

    public void setCreator(SimpleObject creator) {
        this.creator = creator;
    }

    @JsonProperty("partenaire")
    @JacksonXmlProperty(isAttribute = true, localName = "partenaire")
    @JacksonXmlElementWrapper(useWrapping = false)
    public List<SimpleObject> getContributors() {
        return contributors;
    }

    public void setContributors(List<SimpleObject> contributors) {
        this.contributors = contributors;
    }

}