package ru.alex.lab1.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "monster_desc",
        foreignKeys = {@ForeignKey(entity = Monster.class,
                parentColumns = "id",
                childColumns = "monsterId",
                onDelete = ForeignKey.CASCADE)
        })
public class MonsterDescription {

        @PrimaryKey
        private Long id;

        @ColumnInfo(name = "quote")
        private String quote;

        @ColumnInfo(name = "quote_author")
        private String quoteAuthor;

        @ColumnInfo(name = "description")
        private String description;

        private Long monsterId;

        public MonsterDescription(Long id, String quote, String quoteAuthor, String description, Long monsterId) {
                this.id = id;
                this.quote = quote;
                this.quoteAuthor = quoteAuthor;
                this.description = description;
                this.monsterId = monsterId;
        }

        public static MonsterDescriptionBuilder builder() {
                return new MonsterDescriptionBuilder();
        }

        public static class MonsterDescriptionBuilder {
                private Long id;

                private String quote;

                private String quoteAuthor;

                private String description;

                private Long monsterId;

                public MonsterDescriptionBuilder() {
                }

                public MonsterDescriptionBuilder id(Long id) {
                        this.id = id;
                        return this;
                }

                public MonsterDescriptionBuilder quote(String name) {
                        this.quote = name;
                        return this;
                }

                public MonsterDescriptionBuilder quoteAuthor(String quoteAuthor) {
                        this.quoteAuthor = quoteAuthor;
                        return this;
                }

                public MonsterDescriptionBuilder description(String description) {
                        this.description = description;
                        return this;
                }

                public MonsterDescriptionBuilder monsterId(Long monsterId) {
                        this.monsterId = monsterId;
                        return this;
                }

                public MonsterDescription build() {
                        return new MonsterDescription(id, quote, quoteAuthor, description, monsterId);
                }
        }
}
