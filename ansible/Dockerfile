FROM ghcr.io/ansible/creator-ee

ENV ANSIBLE_COLLECTIONS_PATHS=/root/.ansible/collections

RUN pip install requests \
 && ansible-galaxy collection install community.docker
